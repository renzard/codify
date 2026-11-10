"""Εκτελεί κώδικα Python του χρήστη μέσα στην εφαρμογή (μέσω Chaquopy).

Καλείται από την Kotlin: PythonRunner.run(code, ...) -> run_code(source, lang)
Επιστρέφει JSON: {"output": "...", "error": null | "..."}

Προσοχή: δεν είναι sandbox. Ο κώδικας τρέχει με τα δικαιώματα της εφαρμογής.
Έχει όμως όριο χρόνου και όριο εξόδου, ώστε ένας ατέρμονος βρόχος να μην κολλάει την εφαρμογή.
"""
import contextlib
import io
import json
import sys
import time

MAX_SECONDS = 3
MAX_OUTPUT_CHARS = 20000
FILENAME = "<lesson>"

# Μηνύματα της εφαρμογής ανά γλώσσα ("el" = Ελληνικά, "en" = English).
MESSAGES = {
    "el": {
        "output_too_big": "Η έξοδος έγινε πολύ μεγάλη και ο κώδικας σταμάτησε.",
        "timeout": "Ο κώδικας έτρεχε πάνω από %d δευτερόλεπτα και σταμάτησε (ίσως έχεις ατέρμονο βρόχο).",
        "syntax_error": "Συντακτικό σφάλμα (γραμμή %s): %s",
        "no_input": "Η input() δεν υποστηρίζεται σε αυτή την εφαρμογή.",
        "line": " (γραμμή %d)",
    },
    "en": {
        "output_too_big": "The output became too large and the code was stopped.",
        "timeout": "The code ran for more than %d seconds and was stopped (you may have an infinite loop).",
        "syntax_error": "Syntax error (line %s): %s",
        "no_input": "input() is not supported in this app.",
        "line": " (line %d)",
    },
}


class _Stop(BaseException):
    """BaseException, ώστε να μην την πιάνει ένα `except Exception` του χρήστη."""


class _Out(io.StringIO):
    def __init__(self, too_big_message):
        super().__init__()
        self._too_big_message = too_big_message

    def write(self, s):
        if self.tell() > MAX_OUTPUT_CHARS:
            raise _Stop(self._too_big_message)
        return super().write(s)


def _line_of(exc):
    line = None
    tb = exc.__traceback__
    while tb is not None:
        if tb.tb_frame.f_code.co_filename == FILENAME:
            line = tb.tb_lineno
        tb = tb.tb_next
    return line


def run_code(source, lang="en"):
    msg = MESSAGES.get(lang, MESSAGES["en"])
    out = _Out(msg["output_too_big"])
    error = None
    deadline = time.monotonic() + MAX_SECONDS

    def tracer(frame, event, arg):
        if time.monotonic() > deadline:
            raise _Stop(msg["timeout"] % MAX_SECONDS)
        return tracer

    old_stdin = sys.stdin
    sys.stdin = io.StringIO("")  # η input() δεν υποστηρίζεται
    try:
        with contextlib.redirect_stdout(out), contextlib.redirect_stderr(out):
            code = compile(source, FILENAME, "exec")
            sys.settrace(tracer)
            try:
                exec(code, {"__name__": "__main__"})
            finally:
                sys.settrace(None)
    except _Stop as e:
        error = str(e)
    except SystemExit:
        pass
    except SyntaxError as e:
        error = msg["syntax_error"] % (e.lineno, e.msg)
    except EOFError:
        error = msg["no_input"]
    except BaseException as e:
        line = _line_of(e)
        where = msg["line"] % line if line else ""
        error = "%s%s: %s" % (type(e).__name__, where, e)
    finally:
        sys.stdin = old_stdin

    return json.dumps({"output": out.getvalue(), "error": error}, ensure_ascii=False)
