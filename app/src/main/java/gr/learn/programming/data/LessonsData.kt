package gr.learn.programming.data

import gr.learn.programming.model.Language
import gr.learn.programming.model.Lesson
import gr.learn.programming.model.Quiz
import gr.learn.programming.model.UserProgress

fun lessonsFor(language: Language, allLessons: List<Lesson>): List<Lesson> =
    allLessons.filter { it.category.equals(language.name, ignoreCase = true) }

fun isLessonUnlocked(
    lesson: Lesson,
    languageLessons: List<Lesson>,
    progress: UserProgress,
): Boolean {
    val index = languageLessons.indexOfFirst { it.id == lesson.id }
    if (index <= 0) return true
    val previousLesson = languageLessons[index - 1]
    return progress.isCompleted(previousLesson.id)
}

val lessonsEl: List<Lesson> = listOf(
    Lesson(
        id = "python_intro",
        title = "1. Εισαγωγή στην Python",
        category = "Python",
        description = "Η Python είναι μια γλώσσα προγραμματισμού υψηλού επιπέδου που δημιουργήθηκε από τον Guido van Rossum και κυκλοφόρησε το 1991. Διαβάζεται σχεδόν σαν απλά αγγλικά, γι' αυτό είναι ιδανική για αρχάριους.\n\n" +
            "Χρησιμοποιείται σε ανάπτυξη ιστοσελίδων, αυτοματισμούς, ανάλυση δεδομένων, τεχνητή νοημοσύνη και παιχνίδια. Τρέχει σε Windows, Mac, Linux και φυσικά σε κινητά.",
        codeExample = """
            print("Γεια σου, κόσμε!")
            print("Η Python είναι εύκολη")
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο είναι ένα πλεονέκτημα της Python για αρχάριους;",
            options = listOf("Η σύνταξή της διαβάζεται εύκολα", "Χρειάζεται μόνο σε Windows", "Δεν έχει μεταβλητές", "Γράφεται μόνο με αγκύλες { }"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_syntax",
        title = "2. Σύνταξη",
        category = "Python",
        description = "Η σύνταξη είναι οι κανόνες για το πώς γράφουμε σωστό κώδικα. Στην Python κάθε εντολή μπαίνει σε δική της γραμμή και δεν χρειάζεται ερωτηματικό στο τέλος.\n\n" +
            "Η στοίχιση (indentation) είναι υποχρεωτική: τα κενά στην αρχή της γραμμής δείχνουν ποιος κώδικας ανήκει σε ένα μπλοκ. Αν τη γράψεις λάθος, το πρόγραμμα βγάζει σφάλμα.",
        codeExample = """
            if 5 > 2:
                print("Το 5 είναι μεγαλύτερο από το 2")
                print("Αυτή η γραμμή ανήκει στο ίδιο μπλοκ")

            print("Αυτή είναι εκτός μπλοκ")
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι δείχνει η στοίχιση στην Python;",
            options = listOf("Ποιος κώδικας ανήκει σε ένα μπλοκ", "Το χρώμα του κώδικα", "Την ταχύτητα του προγράμματος", "Τίποτα, είναι προαιρετική"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_output",
        title = "3. Έξοδος (print)",
        category = "Python",
        description = "Η συνάρτηση print() εμφανίζει κείμενο ή τιμές στην οθόνη. Μπορείς να της δώσεις πολλά ορίσματα χωρισμένα με κόμμα και τα τυπώνει με ένα κενό ανάμεσα.\n\n" +
            "Με το όρισμα sep αλλάζεις τον διαχωριστή και με το end αλλάζεις το τι μπαίνει στο τέλος (κανονικά είναι αλλαγή γραμμής).",
        codeExample = """
            print("Γεια", "σου", 2026)
            print("Α", "Β", "Γ", sep="-")
            print("Χωρίς αλλαγή γραμμής", end=" ")
            print("συνεχίζει εδώ")
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι τυπώνει η print(\"Α\", \"Β\", sep=\"-\");",
            options = listOf("Α-Β", "Α Β", "ΑΒ", "Α,Β"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_comments",
        title = "4. Σχόλια",
        category = "Python",
        description = "Τα σχόλια είναι σημειώσεις για εσένα και για όποιον διαβάσει τον κώδικα. Η Python τα αγνοεί όταν τρέχει το πρόγραμμα.\n\n" +
            "Ένα σχόλιο ξεκινά με το σύμβολο #. Για σχόλια πολλών γραμμών χρησιμοποιούμε συνήθως πολλές γραμμές με #, ή ένα κείμενο μέσα σε τριπλά εισαγωγικά.",
        codeExample = """
            # Αυτό είναι ένα σχόλιο
            print("Γεια")  # σχόλιο στο τέλος της γραμμής

            # print("Αυτή η γραμμή δεν θα τρέξει")
            print("Τέλος")
        """.trimIndent(),
        quiz = Quiz(
            question = "Με ποιο σύμβολο ξεκινά ένα σχόλιο στην Python;",
            options = listOf("#", "//", "--", "/*"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_variables",
        title = "5. Μεταβλητές",
        category = "Python",
        description = "Μια μεταβλητή είναι ένα «κουτί» στη μνήμη του υπολογιστή, όπου αποθηκεύουμε μια τιμή για να τη χρησιμοποιήσουμε αργότερα. " +
            "Της δίνουμε ένα όνομα και, με το σύμβολο =, της αναθέτουμε μια τιμή.\n\n" +
            "Στην Python δεν χρειάζεται να δηλώσεις τον τύπο της μεταβλητής· τον καταλαβαίνει μόνη της. " +
            "Οι πιο συνηθισμένοι τύποι είναι οι ακέραιοι (int), οι δεκαδικοί (float), τα κείμενα (str) και οι λογικές τιμές (bool).",
        codeExample = """
            name = "Μαρία"       # κείμενο (str)
            age = 25            # ακέραιος (int)
            height = 1.68       # δεκαδικός (float)
            is_student = True   # λογική τιμή (bool)

            print(name)
            print("Η ηλικία μου είναι", age)

            age = age + 1       # αλλάζουμε την τιμή
            print("Του χρόνου θα είμαι", age)
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια εντολή δημιουργεί μια μεταβλητή με όνομα x και τιμή 10;",
            options = listOf("x = 10", "10 = x", "var x == 10", "x <- 10"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_datatypes",
        title = "6. Τύποι δεδομένων",
        category = "Python",
        description = "Κάθε τιμή στην Python έχει έναν τύπο. Οι βασικοί είναι: str (κείμενο), int (ακέραιος), float (δεκαδικός), bool (True/False), list, tuple, set και dict.\n\n" +
            "Με τη συνάρτηση type() βλέπεις τον τύπο μιας τιμής.",
        codeExample = """
            print(type("γεια"))
            print(type(10))
            print(type(3.14))
            print(type(True))
            print(type([1, 2, 3]))
            print(type({"όνομα": "Νίκος"}))
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιος είναι ο τύπος της τιμής 3.14;",
            options = listOf("int", "float", "str", "bool"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_numbers",
        title = "7. Αριθμοί",
        category = "Python",
        description = "Στην Python υπάρχουν τρεις τύποι αριθμών: int (ακέραιοι), float (δεκαδικοί) και complex (μιγαδικοί). Για απλά προγράμματα θα χρησιμοποιείς κυρίως τους δύο πρώτους.\n\n" +
            "Οι ακέραιοι μπορούν να είναι όσο μεγάλοι θέλεις. Οι δεκαδικοί γράφονται με τελεία, όχι με κόμμα.",
        codeExample = """
            a = 7
            b = 2.5
            big = 10 ** 20

            print(a + b)
            print(type(a), type(b))
            print(big)
            print(7 / 2)    # κανονική διαίρεση
            print(7 // 2)   # ακέραια διαίρεση
            print(7 % 2)    # υπόλοιπο
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο είναι το αποτέλεσμα του 7 // 2;",
            options = listOf("3.5", "3", "4", "1"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_casting",
        title = "8. Casting (μετατροπή τύπων)",
        category = "Python",
        description = "Το casting είναι η μετατροπή μιας τιμής από έναν τύπο σε άλλον. Χρησιμοποιούμε τις συναρτήσεις int(), float() και str().\n\n" +
            "Είναι πολύ χρήσιμο όταν έχεις έναν αριθμό γραμμένο ως κείμενο, π.χ. \"5\", και θέλεις να κάνεις πράξεις. Αν η τιμή δεν μπορεί να μετατραπεί (π.χ. int(\"abc\")), προκύπτει σφάλμα.",
        codeExample = """
            x = int("5") + 3
            y = float(2) + 0.5
            z = str(100) + " ευρώ"

            print(x)
            print(y)
            print(z)
            print(int(9.99))   # κόβει το δεκαδικό μέρος
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι επιστρέφει η int(9.99);",
            options = listOf("10", "9", "9.99", "Σφάλμα"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_strings",
        title = "9. Strings (κείμενα)",
        category = "Python",
        description = "Ένα string είναι μια σειρά χαρακτήρων μέσα σε εισαγωγικά, απλά ή διπλά. Κάθε χαρακτήρας έχει δείκτη που ξεκινά από το 0, όπως στις λίστες.\n\n" +
            "Με το slicing παίρνεις κομμάτι του κειμένου: s[0:3] δίνει τους χαρακτήρες από τη θέση 0 έως την 2. Έχει πολλές χρήσιμες μεθόδους: upper(), lower(), replace(), split(), strip().",
        codeExample = """
            s = "Καλημέρα Python"

            print(len(s))
            print(s[0])
            print(s[0:6])
            print(s.upper())
            print(s.replace("Python", "κόσμε"))
            print("Python" in s)
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι επιστρέφει το len(\"abc\");",
            options = listOf("2", "3", "4", "abc"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_booleans",
        title = "10. Booleans",
        category = "Python",
        description = "Ένα bool έχει μόνο δύο τιμές: True (αληθές) και False (ψευδές). Προκύπτει όταν συγκρίνουμε τιμές, π.χ. 10 > 5.\n\n" +
            "Σχεδόν κάθε τιμή θεωρείται True, εκτός από το 0, το κενό κείμενο \"\", την κενή λίστα [] και το None που θεωρούνται False. Με τη bool() το ελέγχεις.",
        codeExample = """
            print(10 > 5)
            print(10 == 5)
            print(bool("γεια"))
            print(bool(""))
            print(bool(0))
            print(bool([1]))
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια από τις παρακάτω τιμές θεωρείται False;",
            options = listOf("\"0\"", "[0]", "0", "\"False\""),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "python_operators",
        title = "11. Τελεστές",
        category = "Python",
        description = "Οι τελεστές εκτελούν πράξεις. Αριθμητικοί: + - * / // % **. Σύγκρισης: == != > < >= <=. Λογικοί: and, or, not.\n\n" +
            "Οι τελεστές ανάθεσης συντομεύουν τον κώδικα: το x += 1 είναι το ίδιο με το x = x + 1. Ο τελεστής in ελέγχει αν κάτι υπάρχει μέσα σε μια λίστα ή κείμενο.",
        codeExample = """
            x = 10
            x += 5
            print(x)
            print(2 ** 3)
            print(x > 10 and x < 20)
            print(not True)
            print(3 in [1, 2, 3])
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει ο τελεστής ** ;",
            options = listOf("Πολλαπλασιάζει", "Υψώνει σε δύναμη", "Βρίσκει υπόλοιπο", "Διαιρεί"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_lists",
        title = "12. Λίστες",
        category = "Python",
        description = "Μια λίστα αποθηκεύει πολλές τιμές σε μία μεταβλητή. Γράφεται μέσα σε αγκύλες [ ] και τα στοιχεία χωρίζονται με κόμμα.\n\n" +
            "Κάθε στοιχείο έχει μια θέση, τον δείκτη (index), που ξεκινά από το 0. " +
            "Έτσι το πρώτο στοιχείο είναι το lista[0], το δεύτερο το lista[1] κ.ο.κ. " +
            "Με την append() προσθέτουμε στοιχείο στο τέλος και με τη len() βρίσκουμε πόσα στοιχεία έχει η λίστα.",
        codeExample = """
            fruits = ["μήλο", "μπανάνα", "πορτοκάλι"]

            print(fruits[0])          # μήλο
            fruits.append("κεράσι")   # προσθήκη στο τέλος
            print(len(fruits))        # 4

            fruits[1] = "ακτινίδιο"   # αλλαγή στοιχείου
            print(fruits)
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιος είναι ο δείκτης (index) του πρώτου στοιχείου μιας λίστας στην Python;",
            options = listOf("0", "1", "-1", "Εξαρτάται από τη λίστα"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_tuples",
        title = "13. Tuples",
        category = "Python",
        description = "Το tuple μοιάζει με λίστα, αλλά είναι αμετάβλητο: μετά τη δημιουργία του δεν μπορείς να αλλάξεις, να προσθέσεις ή να αφαιρέσεις στοιχεία. Γράφεται με παρενθέσεις ( ).\n\n" +
            "Χρησιμοποιείται για δεδομένα που δεν πρέπει να αλλάζουν, π.χ. συντεταγμένες. Το tuple με ένα στοιχείο χρειάζεται κόμμα: (5,).",
        codeExample = """
            point = (10, 20)
            print(point[0])
            print(len(point))

            x, y = point          # αποδόμηση (unpacking)
            print(x, y)

            # point[0] = 99   # Θα έβγαζε σφάλμα!
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια είναι η βασική διαφορά tuple και λίστας;",
            options = listOf("Το tuple δεν αλλάζει μετά τη δημιουργία", "Το tuple είναι πιο αργό", "Το tuple δεν έχει δείκτες", "Η λίστα δεν έχει σειρά"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_sets",
        title = "14. Sets (σύνολα)",
        category = "Python",
        description = "Το set είναι μια συλλογή μοναδικών στοιχείων, χωρίς συγκεκριμένη σειρά. Γράφεται με άγκιστρα { }. Αν προσθέσεις ένα στοιχείο που υπάρχει ήδη, αγνοείται.\n\n" +
            "Είναι ιδανικό για να αφαιρείς διπλότυπα και για πράξεις συνόλων όπως ένωση (|) και τομή (&).",
        codeExample = """
            numbers = {1, 2, 2, 3, 3, 3}
            print(numbers)

            numbers.add(4)
            print(len(numbers))

            a = {1, 2, 3}
            b = {3, 4, 5}
            print(a | b)   # ένωση
            print(a & b)   # τομή
        """.trimIndent(),
        quiz = Quiz(
            question = "Πόσα στοιχεία έχει το set {1, 2, 2, 3};",
            options = listOf("4", "3", "2", "1"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_dictionaries",
        title = "15. Λεξικά (dictionaries)",
        category = "Python",
        description = "Ένα λεξικό αποθηκεύει ζευγάρια κλειδί: τιμή. Γράφεται με { } και βρίσκεις μια τιμή από το κλειδί της, όχι από θέση.\n\n" +
            "Με d[\"κλειδί\"] διαβάζεις ή αλλάζεις τιμή, με keys(), values() και items() παίρνεις όλα τα κλειδιά, τις τιμές ή τα ζευγάρια. Η get() δεν βγάζει σφάλμα αν το κλειδί λείπει.",
        codeExample = """
            person = {"όνομα": "Μαρία", "ηλικία": 25}

            print(person["όνομα"])
            person["πόλη"] = "Αθήνα"     # νέο ζευγάρι
            person["ηλικία"] = 26        # αλλαγή τιμής

            for key, value in person.items():
                print(key, "->", value)

            print(person.get("χρώμα", "άγνωστο"))
        """.trimIndent(),
        quiz = Quiz(
            question = "Πώς διαβάζεις την τιμή του κλειδιού \"όνομα\" από το λεξικό person;",
            options = listOf("person(\"όνομα\")", "person[\"όνομα\"]", "person.όνομα", "person{\"όνομα\"}"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_conditions",
        title = "16. Συνθήκες If/Else",
        category = "Python",
        description = "Οι συνθήκες επιτρέπουν στο πρόγραμμα να παίρνει αποφάσεις. " +
            "Με την if ελέγχουμε αν κάτι ισχύει και, μόνο τότε, εκτελείται το μπλοκ κώδικα που ακολουθεί.\n\n" +
            "Με την elif προσθέτουμε επιπλέον ελέγχους και με την else ορίζουμε τι θα γίνει όταν δεν ισχύει καμία από τις προηγούμενες συνθήκες. " +
            "Προσοχή: στην Python η στοίχιση (τα κενά στην αρχή της γραμμής) είναι υποχρεωτική και δείχνει ποιος κώδικας ανήκει στο μπλοκ.",
        codeExample = """
            temperature = 30

            if temperature > 35:
                print("Κάνει καύσωνα!")
            elif temperature > 20:
                print("Ζέστη, ωραία μέρα.")
            else:
                print("Βάλε κάτι ζεστό.")
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι θα τυπώσει ο κώδικας του παραδείγματος όταν temperature = 30;",
            options = listOf("Κάνει καύσωνα!", "Ζέστη, ωραία μέρα.", "Βάλε κάτι ζεστό.", "Τίποτα"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_match",
        title = "17. Match",
        category = "Python",
        description = "Η match είναι ένας καθαρός τρόπος να ελέγξεις μια τιμή απέναντι σε πολλές περιπτώσεις, αντί για πολλά elif. Υπάρχει από την Python 3.10.\n\n" +
            "Κάθε περίπτωση γράφεται με case. Το σύμβολο _ ταιριάζει με οτιδήποτε και λειτουργεί σαν το else. Με το | ενώνεις πολλές τιμές σε μία περίπτωση.",
        codeExample = """
            day = 6

            match day:
                case 1 | 2 | 3 | 4 | 5:
                    print("Εργάσιμη")
                case 6 | 7:
                    print("Σαββατοκύριακο")
                case _:
                    print("Άγνωστη μέρα")
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει το case _ ;",
            options = listOf("Ταιριάζει με οτιδήποτε (σαν else)", "Σταματά το πρόγραμμα", "Ταιριάζει μόνο με το 0", "Δημιουργεί μεταβλητή"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_loops",
        title = "18. Loops",
        category = "Python",
        description = "Οι βρόχοι (loops) επαναλαμβάνουν κώδικα χωρίς να τον γράφουμε ξανά και ξανά.\n\n" +
            "Ο βρόχος for διατρέχει μια ακολουθία τιμών, π.χ. τους αριθμούς που δίνει η range(). " +
            "Η range(1, 4) δίνει τους αριθμούς 1, 2, 3 (το τελευταίο όριο δεν συμπεριλαμβάνεται).\n\n" +
            "Ο βρόχος while επαναλαμβάνεται όσο ισχύει μια συνθήκη. Φρόντισε η συνθήκη να γίνει κάποια στιγμή ψευδής, αλλιώς ο βρόχος δεν τελειώνει ποτέ.",
        codeExample = """
            # Βρόχος for
            for i in range(1, 4):
                print("Γύρος", i)

            # Βρόχος while
            count = 3
            while count > 0:
                print(count)
                count = count - 1

            print("Ξεκινάμε!")
        """.trimIndent(),
        quiz = Quiz(
            question = "Πόσες φορές θα εκτελεστεί ο βρόχος: for i in range(5): ;",
            options = listOf("4", "5", "6", "Άπειρες"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_range",
        title = "19. Range",
        category = "Python",
        description = "Η range() δημιουργεί μια ακολουθία αριθμών, κυρίως για χρήση σε for. Έχει τρεις μορφές: range(τέλος), range(αρχή, τέλος) και range(αρχή, τέλος, βήμα).\n\n" +
            "Το τέλος δεν συμπεριλαμβάνεται ποτέ. Με αρνητικό βήμα μετράς αντίστροφα. Με list(range(...)) βλέπεις όλους τους αριθμούς.",
        codeExample = """
            print(list(range(5)))
            print(list(range(2, 6)))
            print(list(range(0, 10, 3)))
            print(list(range(5, 0, -1)))

            for i in range(3):
                print("i =", i)
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιους αριθμούς δίνει η range(2, 6);",
            options = listOf("2, 3, 4, 5", "2, 3, 4, 5, 6", "3, 4, 5, 6", "2, 6"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_functions",
        title = "20. Συναρτήσεις",
        category = "Python",
        description = "Μια συνάρτηση είναι ένα κομμάτι κώδικα με όνομα που μπορείς να καλέσεις όσες φορές θέλεις. Ορίζεται με def και μπορεί να δέχεται παραμέτρους.\n\n" +
            "Με το return επιστρέφει ένα αποτέλεσμα. Μπορείς να δώσεις προεπιλεγμένη τιμή σε μια παράμετρο και να καλέσεις τη συνάρτηση με ονόματα ορισμάτων.",
        codeExample = """
            def greet(name, greeting="Γεια σου"):
                return greeting + ", " + name + "!"

            def add(a, b):
                return a + b

            print(greet("Μαρία"))
            print(greet("Νίκο", greeting="Καλημέρα"))
            print(add(3, 4))
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια λέξη-κλειδί ορίζει μια συνάρτηση;",
            options = listOf("function", "def", "func", "fun"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_arrays",
        title = "21. Πίνακες (Arrays)",
        category = "Python",
        description = "Η Python δεν έχει ενσωματωμένο τύπο array· στη θέση του χρησιμοποιούμε λίστες. Οι λίστες κάνουν όλα όσα κάνουν οι πίνακες άλλων γλωσσών.\n\n" +
            "Μπορείς να έχεις και λίστα μέσα σε λίστα, που λειτουργεί σαν δισδιάστατος πίνακας. Η ενότητα της βιβλιοθήκης array υπάρχει για πολύ συγκεκριμένες περιπτώσεις με ένα μόνο τύπο αριθμών.",
        codeExample = """
            grid = [
                [1, 2, 3],
                [4, 5, 6],
            ]

            print(grid[1][2])      # γραμμή 1, στήλη 2
            print(len(grid))

            for row in grid:
                print(row)

            print([x * 2 for x in grid[0]])
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι χρησιμοποιούμε συνήθως στην Python στη θέση των arrays;",
            options = listOf("Λίστες", "Tuples μόνο", "Strings", "Booleans"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_iterators",
        title = "22. Iterators",
        category = "Python",
        description = "Ένας iterator είναι ένα αντικείμενο που δίνει τα στοιχεία μιας συλλογής ένα-ένα. Λίστες, tuples, strings και λεξικά είναι iterable, δηλαδή μπορείς να πάρεις iterator από αυτά με την iter().\n\n" +
            "Η next() επιστρέφει το επόμενο στοιχείο. Όταν τελειώσουν, προκύπτει StopIteration. Ο βρόχος for κάνει όλα αυτά αυτόματα.",
        codeExample = """
            fruits = ["μήλο", "μπανάνα", "κεράσι"]
            it = iter(fruits)

            print(next(it))
            print(next(it))
            print(next(it))

            # Ο βρόχος for χρησιμοποιεί iterator πίσω από τη σκηνή
            for letter in "Py":
                print(letter)
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια συνάρτηση επιστρέφει το επόμενο στοιχείο ενός iterator;",
            options = listOf("next()", "iter()", "step()", "more()"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_modules",
        title = "23. Modules",
        category = "Python",
        description = "Ένα module είναι ένα αρχείο με έτοιμο κώδικα (συναρτήσεις, μεταβλητές) που μπορείς να χρησιμοποιήσεις στο πρόγραμμά σου με το import.\n\n" +
            "Η Python έρχεται με πολλά έτοιμα modules, όπως math, random, datetime και json. Μπορείς να φέρεις μόνο ό,τι χρειάζεσαι με from ... import ... ή να δώσεις συντομότερο όνομα με as.",
        codeExample = """
            import random
            import math as m
            from statistics import mean

            print(random.randint(1, 6))
            print(m.sqrt(49))
            print(mean([2, 4, 6]))
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια εντολή φέρνει ένα module στο πρόγραμμα;",
            options = listOf("include", "import", "require", "using"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_dates",
        title = "24. Ημερομηνίες",
        category = "Python",
        description = "Για ημερομηνίες και ώρες χρησιμοποιούμε το module datetime. Η datetime.now() δίνει την τρέχουσα στιγμή.\n\n" +
            "Με τη strftime() μορφοποιείς την ημερομηνία ως κείμενο: %d ημέρα, %m μήνας, %Y έτος, %H ώρα, %M λεπτά. Με το timedelta προσθέτεις ή αφαιρείς ημέρες.",
        codeExample = """
            from datetime import datetime, date, timedelta

            d = date(2026, 11, 9)
            print(d)
            print(d.strftime("%d/%m/%Y"))
            print(d + timedelta(days=30))

            now = datetime.now()
            print(type(now))
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι σημαίνει το %Y στη strftime();",
            options = listOf("Το έτος με 4 ψηφία", "Ο μήνας", "Η ώρα", "Η ημέρα"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_math",
        title = "25. Μαθηματικά",
        category = "Python",
        description = "Η Python έχει ενσωματωμένες συναρτήσεις όπως min(), max(), abs(), round() και sum(). Για περισσότερα χρησιμοποιούμε το module math.\n\n" +
            "Το math δίνει τη sqrt() (τετραγωνική ρίζα), τη ceil() και floor() (στρογγυλοποίηση πάνω και κάτω), το pi και πολλά άλλα.",
        codeExample = """
            import math

            print(min(3, 7, 1), max(3, 7, 1))
            print(abs(-5))
            print(round(3.14159, 2))
            print(math.sqrt(16))
            print(math.ceil(2.1), math.floor(2.9))
            print(math.pi)
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι επιστρέφει η math.ceil(2.1);",
            options = listOf("2", "3", "2.1", "1"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_json",
        title = "26. JSON",
        category = "Python",
        description = "Το JSON είναι ένα πολύ διαδεδομένο κείμενο για ανταλλαγή δεδομένων ανάμεσα σε προγράμματα και ιστοσελίδες. Μοιάζει με τα λεξικά της Python.\n\n" +
            "Με το module json: η json.loads() μετατρέπει κείμενο JSON σε λεξικό και η json.dumps() μετατρέπει λεξικό σε κείμενο JSON.",
        codeExample = """
            import json

            text = '{"όνομα": "Μαρία", "ηλικία": 25}'
            data = json.loads(text)
            print(data["όνομα"])

            data["ηλικία"] = 26
            print(json.dumps(data, ensure_ascii=False))
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια συνάρτηση μετατρέπει κείμενο JSON σε λεξικό;",
            options = listOf("json.dumps()", "json.loads()", "json.print()", "json.make()"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_regex",
        title = "27. RegEx",
        category = "Python",
        description = "Οι κανονικές εκφράσεις (RegEx) είναι μοτίβα για αναζήτηση κειμένου. Στην Python τις χρησιμοποιείς με το module re.\n\n" +
            "Βασικά σύμβολα: \\d ψηφίο, \\w γράμμα ή ψηφίο, + ένα ή περισσότερα, * μηδέν ή περισσότερα, . οποιοσδήποτε χαρακτήρας. Η findall() βρίσκει όλες τις αντιστοιχίες και η sub() αντικαθιστά.",
        codeExample = """
            import re

            text = "Τηλέφωνα: 6912345678 και 2101234567"

            print(re.findall(r"\d+", text))
            print(re.search(r"\d{10}", text).group())
            print(re.sub(r"\d", "*", "Κωδικός 1234"))
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι ταιριάζει το \\d σε μια κανονική έκφραση;",
            options = listOf("Ένα ψηφίο", "Ένα γράμμα", "Ένα κενό", "Οτιδήποτε"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_pip",
        title = "28. PIP",
        category = "Python",
        description = "Το PIP είναι ο διαχειριστής πακέτων της Python. Με αυτό κατεβάζεις έτοιμες βιβλιοθήκες που έφτιαξε η κοινότητα, π.χ. requests ή numpy.\n\n" +
            "Οι εντολές δίνονται στο τερματικό του υπολογιστή (όχι μέσα στο πρόγραμμα): pip install όνομα, pip uninstall όνομα, pip list. Μέσα σε αυτή την εφαρμογή το PIP δεν εκτελείται, αλλά το παρακάτω παράδειγμα δείχνει πώς ελέγχεις αν μια βιβλιοθήκη υπάρχει.",
        codeExample = """
            # Στο τερματικό του υπολογιστή θα έγραφες:
            #   pip install requests
            #   pip list

            import importlib.util

            for name in ["json", "random", "κάτι_που_δεν_υπάρχει"]:
                found = importlib.util.find_spec(name) is not None
                print(name, "->", "υπάρχει" if found else "δεν υπάρχει")
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια εντολή εγκαθιστά ένα πακέτο με το PIP;",
            options = listOf("pip install όνομα", "pip add όνομα", "python get όνομα", "install pip όνομα"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_try_except",
        title = "29. Try...Except",
        category = "Python",
        description = "Όταν συμβεί σφάλμα, το πρόγραμμα σταματά. Με το try...except μπορείς να «πιάσεις» το σφάλμα και να συνεχίσεις ομαλά.\n\n" +
            "Ο κώδικας που μπορεί να αποτύχει μπαίνει στο try, και το except λέει τι θα γίνει αν αποτύχει. Το else τρέχει αν δεν έγινε σφάλμα και το finally τρέχει πάντα.",
        codeExample = """
            try:
                number = int("abc")
            except ValueError:
                print("Αυτό δεν είναι αριθμός!")
            else:
                print("Όλα καλά:", number)
            finally:
                print("Αυτό τρέχει πάντα")

            try:
                print(10 / 0)
            except ZeroDivisionError:
                print("Δεν διαιρούμε με το μηδέν")
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο μπλοκ εκτελείται ΠΑΝΤΑ, ανεξάρτητα από σφάλμα;",
            options = listOf("try", "except", "else", "finally"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "python_string_formatting",
        title = "30. Μορφοποίηση κειμένου",
        category = "Python",
        description = "Οι f-strings είναι ο πιο εύκολος τρόπος να βάλεις τιμές μέσα σε κείμενο. Γράφεις f πριν από τα εισαγωγικά και βάζεις τις μεταβλητές μέσα σε άγκιστρα { }.\n\n" +
            "Μέσα στα άγκιστρα μπορείς να γράψεις και εκφράσεις, και να ορίσεις μορφή: {x:.2f} δίνει 2 δεκαδικά ψηφία.",
        codeExample = """
            name = "Μαρία"
            price = 4.5
            qty = 3

            print(f"Γεια σου {name}!")
            print(f"Σύνολο: {price * qty:.2f} ευρώ")
            print(f"{qty} επί {price} = {qty * price}")
            print(f"{1234567:,}")
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι τυπώνει το f\"{3.14159:.2f}\";",
            options = listOf("3.14", "3.1", "3.14159", "3.142"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_none",
        title = "31. None",
        category = "Python",
        description = "Το None είναι μια ειδική τιμή που σημαίνει «τίποτα» ή «καμία τιμή». Έχει δικό του τύπο, NoneType.\n\n" +
            "Μια συνάρτηση που δεν έχει return επιστρέφει αυτόματα None. Για να ελέγξεις αν κάτι είναι None χρησιμοποίησε το is None, όχι το ==.",
        codeExample = """
            result = None
            print(result)
            print(result is None)

            def say_hi():
                print("Γεια!")

            value = say_hi()
            print(value)
            print(type(None))
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι επιστρέφει μια συνάρτηση χωρίς return;",
            options = listOf("0", "None", "\"\"", "False"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_user_input",
        title = "32. Είσοδος χρήστη",
        category = "Python",
        description = "Με τη συνάρτηση input() ένα πρόγραμμα ζητά κείμενο από τον χρήστη. Το αποτέλεσμα είναι πάντα string, οπότε για αριθμούς χρειάζεται int() ή float().\n\n" +
            "Μέσα σε αυτή την εφαρμογή η input() δεν υποστηρίζεται, γι' αυτό το παράδειγμα χρησιμοποιεί έτοιμες τιμές. Σε έναν υπολογιστή θα έγραφες age = int(input(\"Ηλικία: \")).",
        codeExample = """
            # Σε υπολογιστή:  name = input("Πώς σε λένε; ")
            name = "Μαρία"
            age_text = "25"            # η input() δίνει πάντα κείμενο

            age = int(age_text)        # μετατροπή σε αριθμό
            print(f"Γεια σου {name}!")
            print("Του χρόνου θα είσαι", age + 1)
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι τύπο έχει πάντα η τιμή που επιστρέφει η input();",
            options = listOf("int", "float", "str", "bool"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "python_virtualenv",
        title = "33. Virtual Environment",
        category = "Python",
        description = "Ένα virtual environment (εικονικό περιβάλλον) είναι ένας ξεχωριστός φάκελος με δική του έκδοση Python και δικά του πακέτα για κάθε project. Έτσι τα projects δεν μπερδεύονται μεταξύ τους.\n\n" +
            "Στο τερματικό: python -m venv myenv για δημιουργία, source myenv/bin/activate για ενεργοποίηση (στα Windows: myenv\\Scripts\\activate) και deactivate για έξοδο.",
        codeExample = """
            # Στο τερματικό του υπολογιστή:
            #   python -m venv myenv
            #   source myenv/bin/activate
            #   pip install requests
            #   deactivate

            import sys
            print("Έκδοση Python:", sys.version.split()[0])
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια εντολή δημιουργεί ένα virtual environment;",
            options = listOf("python -m venv myenv", "pip venv myenv", "python new myenv", "venv install myenv"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_oop",
        title = "34. Προγραμματισμός με αντικείμενα (OOP)",
        category = "Python",
        description = "Ο αντικειμενοστραφής προγραμματισμός (OOP) οργανώνει τον κώδικα γύρω από «αντικείμενα», που συνδυάζουν δεδομένα (ιδιότητες) και ενέργειες (μέθοδοι).\n\n" +
            "Για παράδειγμα, ένα αυτοκίνητο έχει ιδιότητες (χρώμα, ταχύτητα) και μεθόδους (επιτάχυνε, φρέναρε). Οι βασικές ιδέες του OOP είναι: κλάσεις, κληρονομικότητα, πολυμορφισμός και ενθυλάκωση, που θα δούμε στα επόμενα μαθήματα. Στην Python όλα είναι αντικείμενα.",
        codeExample = """
            print(type("κείμενο"))
            print(type(5))
            print(type([1, 2]))

            # Οι μέθοδοι ανήκουν σε αντικείμενα:
            print("python".upper())
            print([3, 1, 2].count(1))
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι συνδυάζει ένα αντικείμενο;",
            options = listOf("Δεδομένα και μεθόδους", "Μόνο αριθμούς", "Μόνο συναρτήσεις", "Μόνο κείμενα"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_classes_objects",
        title = "35. Κλάσεις και αντικείμενα",
        category = "Python",
        description = "Η κλάση είναι το «σχέδιο» και το αντικείμενο είναι κάτι που φτιάχνεται από αυτό το σχέδιο. Ορίζουμε μια κλάση με τη λέξη class και δημιουργούμε αντικείμενο καλώντας την σαν συνάρτηση.\n\n" +
            "Από μία κλάση μπορείς να φτιάξεις όσα αντικείμενα θέλεις και το καθένα έχει τα δικά του δεδομένα.",
        codeExample = """
            class Dog:
                species = "σκύλος"

            d1 = Dog()
            d2 = Dog()

            print(d1.species)
            print(type(d1))
            print(d1 is d2)
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια λέξη-κλειδί ορίζει μια κλάση;",
            options = listOf("object", "class", "def", "new"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_init",
        title = "36. Η μέθοδος __init__",
        category = "Python",
        description = "Η __init__ είναι ειδική μέθοδος που τρέχει αυτόματα κάθε φορά που δημιουργείς ένα νέο αντικείμενο. Τη χρησιμοποιούμε για να δώσουμε αρχικές τιμές στις ιδιότητες.\n\n" +
            "Τα ορίσματα που δίνεις όταν φτιάχνεις το αντικείμενο περνούν στην __init__.",
        codeExample = """
            class Person:
                def __init__(self, name, age):
                    self.name = name
                    self.age = age

            p = Person("Μαρία", 25)
            print(p.name)
            print(p.age)
        """.trimIndent(),
        quiz = Quiz(
            question = "Πότε εκτελείται η __init__;",
            options = listOf("Όταν δημιουργείται νέο αντικείμενο", "Όταν τελειώνει το πρόγραμμα", "Μόνο όταν την καλέσεις ρητά", "Όταν διαγράφεται το αντικείμενο"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_self",
        title = "37. Η παράμετρος self",
        category = "Python",
        description = "Το self αναφέρεται στο ίδιο το αντικείμενο που καλεί τη μέθοδο. Με αυτό μια μέθοδος μπορεί να διαβάσει ή να αλλάξει τις ιδιότητες του αντικειμένου.\n\n" +
            "Πρέπει να είναι η πρώτη παράμετρος κάθε μεθόδου. Όταν καλείς τη μέθοδο, δεν γράφεις το self· η Python το περνά μόνη της. Το όνομα self είναι σύμβαση, αλλά όλοι το χρησιμοποιούν.",
        codeExample = """
            class Counter:
                def __init__(self):
                    self.value = 0

                def add(self):
                    self.value += 1

            a = Counter()
            b = Counter()
            a.add()
            a.add()
            b.add()
            print(a.value, b.value)
        """.trimIndent(),
        quiz = Quiz(
            question = "Σε τι αναφέρεται το self;",
            options = listOf("Στο ίδιο το αντικείμενο", "Στην κλάση-γονέα", "Στο πρόγραμμα", "Σε μια καθολική μεταβλητή"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_class_properties",
        title = "38. Ιδιότητες κλάσης",
        category = "Python",
        description = "Οι ιδιότητες (properties) είναι μεταβλητές που ανήκουν σε ένα αντικείμενο. Τις διαβάζεις με τελεία: αντικείμενο.ιδιότητα, και μπορείς να τις αλλάξεις, να προσθέσεις νέες ή να τις διαγράψεις με del.\n\n" +
            "Υπάρχουν και ιδιότητες κλάσης, που ορίζονται απευθείας μέσα στην κλάση και μοιράζονται σε όλα τα αντικείμενα.",
        codeExample = """
            class Car:
                wheels = 4                 # ιδιότητα κλάσης (κοινή)

                def __init__(self, brand):
                    self.brand = brand     # ιδιότητα αντικειμένου

            c = Car("Toyota")
            print(c.brand, c.wheels)

            c.brand = "Fiat"
            c.color = "κόκκινο"            # νέα ιδιότητα
            print(c.brand, c.color)
            print(Car.wheels)
        """.trimIndent(),
        quiz = Quiz(
            question = "Πώς διαβάζεις την ιδιότητα brand του αντικειμένου c;",
            options = listOf("c.brand", "c[brand]", "c->brand", "brand(c)"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_class_methods",
        title = "39. Μέθοδοι κλάσης",
        category = "Python",
        description = "Οι μέθοδοι είναι συναρτήσεις που ορίζονται μέσα σε μια κλάση και δρουν πάνω στο αντικείμενο. Η πρώτη παράμετρός τους είναι πάντα το self.\n\n" +
            "Μπορούν να δέχονται και άλλα ορίσματα και να επιστρέφουν τιμές, όπως οι απλές συναρτήσεις.",
        codeExample = """
            class BankAccount:
                def __init__(self, balance=0):
                    self.balance = balance

                def deposit(self, amount):
                    self.balance += amount

                def withdraw(self, amount):
                    if amount > self.balance:
                        print("Δεν φτάνουν τα χρήματα")
                    else:
                        self.balance -= amount

            acc = BankAccount(100)
            acc.deposit(50)
            acc.withdraw(30)
            acc.withdraw(500)
            print(acc.balance)
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια είναι η πρώτη παράμετρος μιας μεθόδου κλάσης;",
            options = listOf("self", "this", "class", "object"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_magic_methods",
        title = "40. Μαγικές μέθοδοι",
        category = "Python",
        description = "Οι μαγικές μέθοδοι (dunder methods) έχουν διπλή κάτω παύλα στην αρχή και στο τέλος, π.χ. __str__, __len__, __add__. Η Python τις καλεί μόνη της σε συγκεκριμένες περιπτώσεις.\n\n" +
            "Η __str__ ορίζει πώς τυπώνεται ένα αντικείμενο με print(), η __len__ τι επιστρέφει η len(), και η __add__ τι κάνει ο τελεστής +.",
        codeExample = """
            class Point:
                def __init__(self, x, y):
                    self.x = x
                    self.y = y

                def __str__(self):
                    return f"({self.x}, {self.y})"

                def __add__(self, other):
                    return Point(self.x + other.x, self.y + other.y)

            a = Point(1, 2)
            b = Point(3, 4)
            print(a)
            print(a + b)
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια μαγική μέθοδος ορίζει πώς τυπώνεται ένα αντικείμενο με print();",
            options = listOf("__str__", "__print__", "__text__", "__show__"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_inheritance",
        title = "41. Κληρονομικότητα",
        category = "Python",
        description = "Η κληρονομικότητα επιτρέπει σε μια κλάση (παιδί) να πάρει τις ιδιότητες και τις μεθόδους μιας άλλης (γονέα), ώστε να μην ξαναγράφεις τον ίδιο κώδικα.\n\n" +
            "Γράφεις το όνομα του γονέα σε παρενθέσεις: class Παιδί(Γονέας). Με τη super() καλείς μεθόδους του γονέα, π.χ. την __init__ του.",
        codeExample = """
            class Animal:
                def __init__(self, name):
                    self.name = name

                def eat(self):
                    print(self.name, "τρώει")

            class Dog(Animal):
                def __init__(self, name, breed):
                    super().__init__(name)
                    self.breed = breed

                def bark(self):
                    print(self.name, "γαβγίζει")

            d = Dog("Ρεξ", "Λαμπραντόρ")
            d.eat()      # κληρονομήθηκε από την Animal
            d.bark()
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η super();",
            options = listOf("Δίνει πρόσβαση στην κλάση-γονέα", "Σβήνει την κλάση", "Φτιάχνει νέο αντικείμενο", "Τερματίζει το πρόγραμμα"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_polymorphism",
        title = "42. Πολυμορφισμός",
        category = "Python",
        description = "Πολυμορφισμός σημαίνει «πολλές μορφές»: διαφορετικές κλάσεις μπορούν να έχουν μέθοδο με το ίδιο όνομα, που κάνει κάτι διαφορετικό στην καθεμία.\n\n" +
            "Έτσι μπορείς να καλέσεις την ίδια μέθοδο σε διαφορετικά αντικείμενα χωρίς να ξέρεις τι ακριβώς είναι. Μια κλάση-παιδί μπορεί επίσης να αντικαταστήσει (override) μια μέθοδο του γονέα.",
        codeExample = """
            class Dog:
                def speak(self):
                    return "Γαβ!"

            class Cat:
                def speak(self):
                    return "Μιάου!"

            class Cow:
                def speak(self):
                    return "Μουυ!"

            for animal in [Dog(), Cat(), Cow()]:
                print(animal.speak())
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι επιτρέπει ο πολυμορφισμός;",
            options = listOf("Την ίδια μέθοδο με διαφορετική συμπεριφορά ανά κλάση", "Να έχει μία κλάση μόνο ένα αντικείμενο", "Να μην χρειάζονται μέθοδοι", "Να τρέχει ο κώδικας πιο γρήγορα"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_encapsulation",
        title = "43. Ενθυλάκωση",
        category = "Python",
        description = "Η ενθυλάκωση (encapsulation) σημαίνει ότι κρύβουμε τα εσωτερικά δεδομένα μιας κλάσης, ώστε να αλλάζουν μόνο μέσα από ελεγχόμενες μεθόδους.\n\n" +
            "Στην Python, ένα όνομα με _ στην αρχή δείχνει «εσωτερικό, μην το πειράζεις», ενώ με __ (δύο κάτω παύλες) η Python το κρύβει περισσότερο και δεν μπορείς να το προσπελάσεις απευθείας από έξω.",
        codeExample = """
            class Wallet:
                def __init__(self):
                    self.__money = 0          # ιδιωτική ιδιότητα

                def add(self, amount):
                    if amount > 0:
                        self.__money += amount

                def get_money(self):
                    return self.__money

            w = Wallet()
            w.add(50)
            w.add(-20)                        # απορρίπτεται
            print(w.get_money())

            try:
                print(w.__money)
            except AttributeError:
                print("Δεν έχεις άμεση πρόσβαση!")
        """.trimIndent(),
        quiz = Quiz(
            question = "Πώς δηλώνεται μια ιδιωτική ιδιότητα στην Python;",
            options = listOf("Με δύο κάτω παύλες στην αρχή, π.χ. __money", "Με τη λέξη private", "Με αστερίσκο *", "Με τη λέξη hidden"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_inner_classes",
        title = "44. Εσωτερικές κλάσεις",
        category = "Python",
        description = "Μια εσωτερική κλάση (inner class) είναι μια κλάση που ορίζεται μέσα σε άλλη κλάση. Χρησιμεύει όταν μια κλάση έχει νόημα μόνο μέσα στο πλαίσιο της άλλης.\n\n" +
            "Για παράδειγμα, ένα Αυτοκίνητο μπορεί να έχει μέσα του μια κλάση Κινητήρας. Δημιουργείς το εσωτερικό αντικείμενο μέσα στην __init__ της εξωτερικής κλάσης.",
        codeExample = """
            class Car:
                def __init__(self, brand):
                    self.brand = brand
                    self.engine = self.Engine(120)

                class Engine:
                    def __init__(self, horsepower):
                        self.horsepower = horsepower

                    def describe(self):
                        return f"Κινητήρας {self.horsepower} ίππων"

            c = Car("Fiat")
            print(c.brand)
            print(c.engine.describe())
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι είναι μια εσωτερική κλάση;",
            options = listOf("Κλάση που ορίζεται μέσα σε άλλη κλάση", "Κλάση χωρίς μεθόδους", "Κλάση που δεν μπορεί να έχει αντικείμενα", "Κλάση από άλλο αρχείο"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "linux_intro",
        title = "1. Τι είναι το Linux",
        category = "Linux",
        description = "Το Linux είναι ένα λειτουργικό σύστημα ανοιχτού κώδικα, όπως τα Windows και το macOS. Τρέχει στους περισσότερους διακομιστές του κόσμου, στα κινητά Android και σε πολλούς υπολογιστές.\n\n" +
            "Με το Linux δουλεύουμε συχνά μέσα από το τερματικό (terminal): ένα παράθυρο όπου πληκτρολογούμε εντολές και πατάμε Enter. Το πρόγραμμα που διαβάζει τις εντολές λέγεται shell (συνήθως bash).\n\n" +
            "Η echo τυπώνει κείμενο, η whoami δείχνει το όνομα χρήστη σου και η uname το όνομα του συστήματος.",
        codeExample = """
            echo "Γεια σου, Linux!"
            whoami
            uname
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι είναι το τερματικό;",
            options = listOf("Ένα παράθυρο όπου πληκτρολογούμε εντολές", "Ένα πρόγραμμα για επεξεργασία φωτογραφιών", "Ένας τύπος αρχείου", "Ένα antivirus"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Γεια σου, Linux!
            maria
            Linux
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_pwd",
        title = "2. Πού βρίσκομαι (pwd)",
        category = "Linux",
        description = "Το τερματικό «βρίσκεται» πάντα μέσα σε έναν φάκελο. Η εντολή pwd (print working directory) εμφανίζει τη διαδρομή του φακέλου όπου βρίσκεσαι τώρα.\n\n" +
            "Η διαδρομή ξεκινά από τη ρίζα / και κάθε φάκελος χωρίζεται με /. Ο προσωπικός σου φάκελος (home) είναι συνήθως ο /home/όνομα.",
        codeExample = """
            echo "Βρίσκομαι εδώ:"
            pwd
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η εντολή pwd;",
            options = listOf("Δείχνει τον φάκελο στον οποίο βρίσκεσαι", "Αλλάζει τον κωδικό σου", "Δημιουργεί έναν φάκελο", "Καθαρίζει την οθόνη"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Βρίσκομαι εδώ:
            /home/maria
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_ls",
        title = "3. Λίστα αρχείων (ls)",
        category = "Linux",
        description = "Η εντολή ls δείχνει τι περιέχει ο τρέχων φάκελος. Οι επιλογές (options) αλλάζουν τη συμπεριφορά της και γράφονται μετά από παύλα.\n\n" +
            "Το -l δείχνει αναλυτική λίστα (δικαιώματα, μέγεθος, ημερομηνία) και το -a δείχνει και τα κρυφά αρχεία, δηλαδή αυτά που το όνομά τους αρχίζει με τελεία.",
        codeExample = """
            ls
            ls -l
            ls -a
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια εντολή δείχνει και τα κρυφά αρχεία;",
            options = listOf("ls -a", "ls -l", "ls -r", "ls -t"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Documents  Downloads  notes.txt
            total 12
            drwxr-xr-x 2 maria maria 4096 Nov 10 09:15 Documents
            drwxr-xr-x 2 maria maria 4096 Nov 10 09:16 Downloads
            -rw-r--r-- 1 maria maria   42 Nov 10 09:20 notes.txt
            .  ..  .bashrc  Documents  Downloads  notes.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_cd",
        title = "4. Αλλαγή φακέλου (cd)",
        category = "Linux",
        description = "Η εντολή cd (change directory) σε μεταφέρει σε άλλο φάκελο. Γράφεις το όνομα του φακέλου μετά την εντολή.\n\n" +
            "Το .. σημαίνει «ένας φάκελος πάνω», το . σημαίνει «ο τρέχων φάκελος» και το ~ είναι ο προσωπικός σου φάκελος (home). Η cd χωρίς τίποτα άλλο σε πάει επίσης στο home.",
        codeExample = """
            pwd
            cd Documents
            pwd
            cd ..
            pwd
            cd ~
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η εντολή cd ..;",
            options = listOf("Σε πάει έναν φάκελο πάνω", "Σε πάει στο home", "Δημιουργεί φάκελο με όνομα ..", "Σβήνει τον τρέχοντα φάκελο"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            /home/maria
            /home/maria/Documents
            /home/maria
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_mkdir",
        title = "5. Δημιουργία φακέλων (mkdir)",
        category = "Linux",
        description = "Η mkdir (make directory) δημιουργεί νέο φάκελο. Μπορείς να δώσεις περισσότερα από ένα ονόματα στην ίδια εντολή.\n\n" +
            "Με την επιλογή -p δημιουργούνται μαζί και οι ενδιάμεσοι φάκελοι που λείπουν, π.χ. το mkdir -p a/b/c φτιάχνει και τα τρία επίπεδα με μιας.",
        codeExample = """
            mkdir projects
            mkdir -p projects/linux/notes
            ls projects
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η επιλογή -p στην mkdir;",
            options = listOf("Δημιουργεί και τους ενδιάμεσους φακέλους", "Προστατεύει τον φάκελο με κωδικό", "Τυπώνει το όνομα του φακέλου", "Δημιουργεί αρχείο αντί για φάκελο"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            linux
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_touch",
        title = "6. Δημιουργία αρχείων (touch)",
        category = "Linux",
        description = "Η touch δημιουργεί ένα νέο, κενό αρχείο. Αν το αρχείο υπάρχει ήδη, δεν σβήνει το περιεχόμενό του, απλώς ενημερώνει την ώρα τροποποίησής του.\n\n" +
            "Μπορείς να δημιουργήσεις πολλά αρχεία με μία εντολή, χωρίζοντας τα ονόματα με κενό.",
        codeExample = """
            mkdir practice
            cd practice
            touch hello.txt
            touch a.txt b.txt
            ls
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η touch όταν το αρχείο υπάρχει ήδη;",
            options = listOf("Δεν σβήνει το περιεχόμενο, αλλάζει μόνο την ώρα τροποποίησης", "Σβήνει το αρχείο", "Το αντιγράφει", "Βγάζει πάντα σφάλμα"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            a.txt  b.txt  hello.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_redirect",
        title = "7. Ανακατεύθυνση εξόδου (> και >>)",
        category = "Linux",
        description = "Κανονικά η έξοδος μιας εντολής εμφανίζεται στην οθόνη. Με το > τη στέλνουμε σε αρχείο. Αν το αρχείο υπάρχει, το περιεχόμενό του αντικαθίσταται.\n\n" +
            "Με το >> η έξοδος προστίθεται στο τέλος του αρχείου, χωρίς να σβηστούν τα παλιά. Για να δούμε το αρχείο χρησιμοποιούμε την cat, που θα τη μάθουμε στο επόμενο μάθημα.",
        codeExample = """
            echo "Hello" > hello.txt
            echo "Linux" >> hello.txt
            cat hello.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια διαφορά έχει το >> από το >;",
            options = listOf("Προσθέτει στο τέλος του αρχείου αντί να το αντικαταστήσει", "Δεν έχει καμία διαφορά", "Σβήνει το αρχείο", "Στέλνει την έξοδο στην οθόνη"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Hello
            Linux
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_cat",
        title = "8. Προβολή αρχείων (cat)",
        category = "Linux",
        description = "Η cat εμφανίζει το περιεχόμενο ενός αρχείου στην οθόνη. Είναι ιδανική για μικρά αρχεία. Αν δώσεις περισσότερα από ένα αρχεία, τα εμφανίζει το ένα μετά το άλλο.\n\n" +
            "Με την επιλογή -n αριθμεί τις γραμμές. Για μεγάλα αρχεία υπάρχει και η less, όπου κινείσαι με τα βέλη και βγαίνεις με το q.",
        codeExample = """
            echo "line 1" > notes.txt
            echo "line 2" >> notes.txt
            cat notes.txt
            cat -n notes.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η εντολή cat αρχείο.txt;",
            options = listOf("Εμφανίζει το περιεχόμενο του αρχείου", "Σβήνει το αρχείο", "Δημιουργεί φάκελο", "Αλλάζει το όνομα του αρχείου"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            line 1
            line 2
                 1	line 1
                 2	line 2
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_cp",
        title = "9. Αντιγραφή (cp)",
        category = "Linux",
        description = "Η cp αντιγράφει αρχεία: cp πηγή προορισμός. Το πρώτο όνομα είναι το αρχείο που υπάρχει και το δεύτερο το νέο αντίγραφο ή ο φάκελος όπου θα μπει.\n\n" +
            "Για να αντιγράψεις ολόκληρο φάκελο με ό,τι περιέχει χρειάζεσαι την επιλογή -r (recursive).",
        codeExample = """
            echo "data" > a.txt
            cp a.txt b.txt
            mkdir folder
            cp a.txt folder/
            cp -r folder folder2
            ls
            ls folder2
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια εντολή αντιγράφει έναν φάκελο με το περιεχόμενό του;",
            options = listOf("cp -r", "cp -n", "cp -v", "cp -i"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            a.txt  b.txt  folder  folder2
            a.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_mv",
        title = "10. Μετακίνηση και μετονομασία (mv)",
        category = "Linux",
        description = "Η mv μετακινεί αρχεία και φακέλους: mv πηγή προορισμός. Αν ο προορισμός είναι φάκελος, το αρχείο μπαίνει μέσα του.\n\n" +
            "Η ίδια εντολή κάνει και μετονομασία: στο Linux η μετονομασία είναι απλώς μετακίνηση με νέο όνομα.",
        codeExample = """
            touch old.txt
            mv old.txt new.txt
            mkdir docs
            mv new.txt docs/
            ls
            ls docs
        """.trimIndent(),
        quiz = Quiz(
            question = "Πώς μετονομάζεις ένα αρχείο στο Linux;",
            options = listOf("mv old.txt new.txt", "ren old.txt new.txt", "name old.txt new.txt", "touch old.txt new.txt"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            docs
            new.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_rm",
        title = "11. Διαγραφή (rm και rmdir)",
        category = "Linux",
        description = "Η rm σβήνει αρχεία. Προσοχή: στο τερματικό δεν υπάρχει κάδος ανακύκλωσης, οπότε ό,τι σβήσεις χάνεται οριστικά.\n\n" +
            "Η rmdir σβήνει μόνο κενούς φακέλους. Για φάκελο με περιεχόμενο χρησιμοποίησε rm -r. Πρόσεχε ιδιαίτερα με το rm -r και έλεγχε πάντα το όνομα πριν πατήσεις Enter.",
        codeExample = """
            touch a.txt b.txt
            mkdir old
            rm a.txt
            rmdir old
            mkdir -p full/inside
            rm -r full
            ls
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια εντολή σβήνει έναν φάκελο που έχει αρχεία μέσα;",
            options = listOf("rm -r folder", "rmdir folder", "rm folder", "delete folder"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            b.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_headtail",
        title = "12. Αρχή και τέλος αρχείου (head, tail)",
        category = "Linux",
        description = "Η head δείχνει τις πρώτες γραμμές ενός αρχείου και η tail τις τελευταίες. Από προεπιλογή δείχνουν 10 γραμμές και με την επιλογή -n αλλάζεις τον αριθμό.\n\n" +
            "Η tail είναι πολύ χρήσιμη για αρχεία καταγραφής (logs), όπου το πιο πρόσφατο γεγονός είναι στο τέλος. Η εντολή seq 1 10 τυπώνει τους αριθμούς από το 1 έως το 10 και τη χρησιμοποιούμε εδώ για να φτιάξουμε ένα δοκιμαστικό αρχείο.",
        codeExample = """
            seq 1 10 > numbers.txt
            head -n 3 numbers.txt
            tail -n 3 numbers.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια εντολή δείχνει τις τελευταίες 3 γραμμές ενός αρχείου;",
            options = listOf("tail -n 3 numbers.txt", "head -n 3 numbers.txt", "cat -n 3 numbers.txt", "last 3 numbers.txt"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            1
            2
            3
            8
            9
            10
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_wc",
        title = "13. Μέτρημα (wc)",
        category = "Linux",
        description = "Η wc (word count) μετράει γραμμές, λέξεις και bytes ενός αρχείου. Χωρίς επιλογές τυπώνει και τα τρία νούμερα με αυτή τη σειρά.\n\n" +
            "Με το -l μετράς μόνο γραμμές, με το -w μόνο λέξεις και με το -c μόνο bytes.",
        codeExample = """
            seq 1 10 > numbers.txt
            wc -l numbers.txt
            wc -w numbers.txt
            wc numbers.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια επιλογή της wc μετράει μόνο τις γραμμές;",
            options = listOf("-l", "-w", "-c", "-m"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            10 numbers.txt
            10 numbers.txt
             10  10  21 numbers.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_grep",
        title = "14. Αναζήτηση κειμένου (grep)",
        category = "Linux",
        description = "Η grep ψάχνει μέσα σε αρχεία και τυπώνει μόνο τις γραμμές που περιέχουν το κείμενο που ζητάς: grep κείμενο αρχείο.\n\n" +
            "Βασικές επιλογές: -i αγνοεί τα κεφαλαία και τα πεζά, -n δείχνει τον αριθμό γραμμής, -c μετράει πόσες γραμμές ταιριάζουν και -r ψάχνει μέσα σε όλους τους φακέλους.",
        codeExample = """
            echo "apple" > fruits.txt
            echo "banana" >> fruits.txt
            echo "apple pie" >> fruits.txt
            grep apple fruits.txt
            grep -n banana fruits.txt
            grep -i APPLE fruits.txt
            grep -c apple fruits.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η επιλογή -i στη grep;",
            options = listOf("Αγνοεί τη διαφορά κεφαλαίων και πεζών", "Δείχνει αριθμούς γραμμών", "Σβήνει τις γραμμές που ταιριάζουν", "Ψάχνει μέσα σε φακέλους"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            apple
            apple pie
            2:banana
            apple
            apple pie
            2
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_pipe",
        title = "15. Σωληνώσεις (|)",
        category = "Linux",
        description = "Ο χαρακτήρας | (pipe) στέλνει την έξοδο μιας εντολής ως είσοδο στην επόμενη. Έτσι συνδυάζεις μικρές εντολές για πιο σύνθετες δουλειές.\n\n" +
            "Παράδειγμα: το ls | wc -l μετράει πόσα αρχεία έχει ο φάκελος, γιατί η wc -l παίρνει ως είσοδο τη λίστα της ls.",
        codeExample = """
            mkdir demo
            cd demo
            seq 1 20 > numbers.txt
            head -n 3 numbers.txt | tail -n 1
            ls | wc -l
            cat numbers.txt | grep 1 | wc -l
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει ο χαρακτήρας | ανάμεσα σε δύο εντολές;",
            options = listOf("Στέλνει την έξοδο της πρώτης ως είσοδο στη δεύτερη", "Εκτελεί μόνο τη δεύτερη εντολή", "Γράφει την έξοδο σε αρχείο", "Σβήνει την έξοδο της πρώτης"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            3
            1
            11
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_find",
        title = "16. Αναζήτηση αρχείων (find)",
        category = "Linux",
        description = "Η find ψάχνει αρχεία και φακέλους μέσα σε μια διαδρομή: find διαδρομή κριτήρια. Η σειρά με την οποία εμφανίζονται τα αποτελέσματα μπορεί να διαφέρει από σύστημα σε σύστημα.\n\n" +
            "Με το -name ψάχνεις με όνομα (ο αστερίσκος * αντικαθιστά οποιοδήποτε κείμενο) και με το -type f ή -type d περιορίζεις το αποτέλεσμα σε αρχεία ή φακέλους αντίστοιχα.",
        codeExample = """
            mkdir -p project/src
            touch project/readme.txt project/src/main.py project/src/util.py
            find project -name "*.py"
            find project -type d
            find project -type f
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι βρίσκει η εντολή find . -name \"*.txt\";",
            options = listOf("Όλα τα αρχεία με κατάληξη .txt", "Μόνο φακέλους που λέγονται txt", "Τα αρχεία που περιέχουν τη λέξη txt", "Τίποτα, είναι λάθος εντολή"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            project/src/main.py
            project/src/util.py
            project
            project/src
            project/readme.txt
            project/src/main.py
            project/src/util.py
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_help",
        title = "17. Βοήθεια (--help και man)",
        category = "Linux",
        description = "Δεν χρειάζεται να θυμάσαι όλες τις επιλογές. Οι περισσότερες εντολές δέχονται το --help και τυπώνουν σύντομη βοήθεια.\n\n" +
            "Η man (manual) ανοίγει το πλήρες εγχειρίδιο μιας εντολής. Κινείσαι με τα βέλη, ψάχνεις με το / και βγαίνεις με το q. Η whatis δίνει μια περιγραφή σε μία γραμμή.",
        codeExample = """
            ls --help
            whatis ls
            man ls
        """.trimIndent(),
        quiz = Quiz(
            question = "Πώς βγαίνεις από τη σελίδα του man;",
            options = listOf("Πατώντας q", "Πατώντας x", "Πατώντας Enter", "Πατώντας Space"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Usage: ls [OPTION]... [FILE]...
            List information about the FILEs (the current directory by default).
            ...
            ls (1)               - list directory contents
            (η man ανοίγει το εγχειρίδιο, πάτα q για έξοδο)
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_chmod",
        title = "18. Δικαιώματα (chmod)",
        category = "Linux",
        description = "Κάθε αρχείο έχει δικαιώματα για τρεις κατηγορίες: τον ιδιοκτήτη, την ομάδα και τους άλλους. Το καθένα μπορεί να έχει r (ανάγνωση), w (εγγραφή) και x (εκτέλεση). Τα βλέπεις με ls -l, π.χ. -rw-r--r--.\n\n" +
            "Η chmod αλλάζει τα δικαιώματα. Το chmod +x κάνει ένα αρχείο εκτελέσιμο. Με αριθμούς: r=4, w=2, x=1, άρα το 600 σημαίνει ανάγνωση και εγγραφή μόνο για τον ιδιοκτήτη.",
        codeExample = """
            touch script.sh
            ls -l script.sh
            chmod +x script.sh
            ls -l script.sh
            chmod 600 script.sh
            ls -l script.sh
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η εντολή chmod +x script.sh;",
            options = listOf("Κάνει το αρχείο εκτελέσιμο", "Σβήνει το αρχείο", "Αντιγράφει το αρχείο", "Κρύβει το αρχείο"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            -rw-r--r-- 1 maria maria 0 Nov 10 10:00 script.sh
            -rwxr-xr-x 1 maria maria 0 Nov 10 10:00 script.sh
            -rw------- 1 maria maria 0 Nov 10 10:00 script.sh
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_sudo",
        title = "19. Διαχειριστής (sudo)",
        category = "Linux",
        description = "Ο χρήστης root είναι ο διαχειριστής του συστήματος και μπορεί να κάνει τα πάντα. Για ασφάλεια δεν δουλεύουμε συνεχώς ως root: όταν χρειάζεται, βάζουμε μπροστά από την εντολή τη λέξη sudo και πληκτρολογούμε τον κωδικό μας.\n\n" +
            "Το sudo χρειάζεται π.χ. για εγκατάσταση προγραμμάτων. Σε Debian και Ubuntu χρησιμοποιούμε την apt: το sudo apt update ανανεώνει τη λίστα των διαθέσιμων προγραμμάτων. Άλλες διανομές έχουν άλλους διαχειριστές πακέτων (dnf, pacman).",
        codeExample = """
            whoami
            sudo whoami
            sudo apt update
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η λέξη sudo μπροστά από μια εντολή;",
            options = listOf("Τρέχει την εντολή με δικαιώματα διαχειριστή", "Σβήνει την εντολή", "Τρέχει την εντολή στο παρασκήνιο", "Τρέχει την εντολή δύο φορές"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            maria
            [sudo] password for maria:
            root
            Hit:1 http://archive.ubuntu.com/ubuntu noble InRelease
            Reading package lists... Done
            Building dependency tree... Done
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_shortcuts",
        title = "20. Συντομεύσεις και ιστορικό",
        category = "Linux",
        description = "Το τερματικό έχει εργαλεία που εξοικονομούν χρόνο. Με το πλήκτρο Tab συμπληρώνεται αυτόματα το όνομα αρχείου ή εντολής και με το βέλος πάνω ξαναφέρνεις προηγούμενες εντολές.\n\n" +
            "Η history δείχνει τις εντολές που έχεις γράψει. Το Ctrl+C σταματά μια εντολή που τρέχει και το Ctrl+L (ή η εντολή clear) καθαρίζει την οθόνη. Η date δείχνει την ημερομηνία και την ώρα.",
        codeExample = """
            history | tail -n 3
            date
            clear
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιος συνδυασμός σταματά μια εντολή που τρέχει;",
            options = listOf("Ctrl+C", "Ctrl+V", "Ctrl+L", "Tab"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
               98  pwd
               99  ls -l
              100  history | tail -n 3
            Tue Nov 10 10:30:00 UTC 2026
            (η clear καθαρίζει την οθόνη)
        """.trimIndent(),
    ),
    Lesson(
        id = "html_intro",
        title = "1. Τι είναι η HTML",
        category = "HTML",
        description = "Η HTML (HyperText Markup Language) είναι η γλώσσα με την οποία φτιάχνονται οι ιστοσελίδες. Δεν είναι γλώσσα προγραμματισμού: περιγράφει τη δομή της σελίδας, δηλαδή ποιο κομμάτι είναι τίτλος, ποιο παράγραφος, ποιο εικόνα.\n\n" +
            "Η HTML αποτελείται από ετικέτες (tags) μέσα σε γωνιακές αγκύλες, π.χ. <p>. Τα περισσότερα tags έχουν αρχή και τέλος: το <p> ανοίγει και το </p> κλείνει. Όλο μαζί, με το περιεχόμενο, λέγεται στοιχείο (element). Πάτα «Προεπισκόπηση» για να δεις το αποτέλεσμα.",
        codeExample = """
            <h1>Γεια σου, HTML!</h1>
            <p>Αυτή είναι η πρώτη μου σελίδα.</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι περιγράφει η HTML;",
            options = listOf("Τη δομή μιας ιστοσελίδας", "Τη λογική ενός προγράμματος", "Τη βάση δεδομένων ενός site", "Τον τρόπο λειτουργίας του διακομιστή"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_editors",
        title = "2. Επεξεργαστές κώδικα",
        category = "HTML",
        description = "Μια σελίδα HTML είναι απλό αρχείο κειμένου. Για να την γράψεις αρκεί ένας επεξεργαστής κειμένου, όπως το Σημειωματάριο (Notepad), ή ένας επεξεργαστής κώδικα, όπως το VS Code, που χρωματίζει τον κώδικα και σε βοηθά με αυτόματη συμπλήρωση.\n\n" +
            "Αποθηκεύεις το αρχείο με κατάληξη .html και το ανοίγεις με διπλό κλικ στον browser. Όταν αλλάζεις τον κώδικα, αποθηκεύεις και ανανεώνεις τη σελίδα για να δεις την αλλαγή.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <title>index.html</title>
            </head>
            <body>
              <h1>My first file</h1>
              <p>Saved as index.html</p>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Με ποια κατάληξη αποθηκεύεται ένα αρχείο HTML;",
            options = listOf(".html", ".txt", ".exe", ".doc"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_structure",
        title = "3. Η δομή μιας σελίδας",
        category = "HTML",
        description = "Κάθε HTML σελίδα έχει την ίδια βασική δομή. Το <!DOCTYPE html> δηλώνει ότι πρόκειται για σύγχρονη HTML και το <html> περιέχει όλη τη σελίδα.\n\n" +
            "Μέσα στο <head> μπαίνουν πληροφορίες που δεν φαίνονται στη σελίδα, όπως ο τίτλος <title> που εμφανίζεται στην καρτέλα του browser. Μέσα στο <body> μπαίνει ό,τι βλέπει ο χρήστης.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <title>Η σελίδα μου</title>
            </head>
            <body>
              <h1>Καλώς ήρθες!</h1>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Πού μπαίνει το περιεχόμενο που βλέπει ο χρήστης;",
            options = listOf("Μέσα στο <body>", "Μέσα στο <head>", "Μέσα στο <title>", "Μέσα στο <!DOCTYPE>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_elements",
        title = "4. Στοιχεία (elements)",
        category = "HTML",
        description = "Ένα στοιχείο HTML αποτελείται από το tag έναρξης, το περιεχόμενο και το tag λήξης, π.χ. <p>Κείμενο</p>. Τα στοιχεία μπορούν να μπαίνουν το ένα μέσα στο άλλο, όπως το <b> μέσα σε ένα <p>.\n\n" +
            "Υπάρχουν και κενά στοιχεία, όπως το <br> και το <hr>, που δεν έχουν περιεχόμενο ούτε tag λήξης.",
        codeExample = """
            <p>This is a <b>paragraph</b> with a nested element.</p>
            <p>Line one<br>Line two</p>
            <hr>
            <p>br and hr are empty elements.</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο από τα παρακάτω είναι κενό στοιχείο;",
            options = listOf("<p>", "<br>", "<h1>", "<div>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_attributes",
        title = "5. Ιδιότητες (attributes)",
        category = "HTML",
        description = "Οι ιδιότητες δίνουν επιπλέον πληροφορίες σε ένα tag. Γράφονται μέσα στο tag που ανοίγει, με τη μορφή όνομα=\"τιμή\".\n\n" +
            "Συχνές ιδιότητες: id (μοναδικό όνομα στοιχείου), class (όνομα ομάδας που μπορεί να επαναληφθεί) και title (κείμενο που εμφανίζεται όταν περνάς το ποντίκι). Το id πρέπει να είναι μοναδικό σε όλη τη σελίδα.",
        codeExample = """
            <p id="intro" class="note" title="Μια σημείωση">Αυτή η παράγραφος έχει τρεις ιδιότητες.</p>
            <p class="note">Αυτή έχει την ίδια class.</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα πρέπει να έχει μοναδική τιμή σε όλη τη σελίδα;",
            options = listOf("id", "class", "title", "style"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_headings",
        title = "6. Επικεφαλίδες",
        category = "HTML",
        description = "Οι επικεφαλίδες ορίζουν τους τίτλους. Υπάρχουν έξι επίπεδα, από <h1> (το μεγαλύτερο και πιο σημαντικό) έως <h6> (το μικρότερο).\n\n" +
            "Χρησιμοποίησε ένα <h1> ανά σελίδα για τον κύριο τίτλο και τα υπόλοιπα επίπεδα για υπότιτλους. Τα επιλέγεις για τη σημασία τους και όχι για το μέγεθος.",
        codeExample = """
            <h1>Κύριος τίτλος</h1>
            <h2>Υπότιτλος</h2>
            <h3>Μικρότερος υπότιτλος</h3>
            <h6>Ο μικρότερος τίτλος</h6>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια είναι η μεγαλύτερη επικεφαλίδα;",
            options = listOf("<h1>", "<h6>", "<head>", "<title>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_paragraphs",
        title = "7. Παράγραφοι και αλλαγή γραμμής",
        category = "HTML",
        description = "Το <p> ορίζει μια παράγραφο. Ο browser αγνοεί τα επιπλέον κενά και τις αλλαγές γραμμής μέσα στον κώδικα, οπότε χρειάζεσαι tags για να τα ελέγξεις.\n\n" +
            "Το <br> κάνει αλλαγή γραμμής μέσα στην παράγραφο και το <hr> βάζει οριζόντια γραμμή. Αυτά τα δύο δεν έχουν tag κλεισίματος.",
        codeExample = """
            <p>Πρώτη παράγραφος.</p>
            <p>Πρώτη γραμμή<br>Δεύτερη γραμμή</p>
            <hr>
            <p>Τελευταία παράγραφος.</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag κάνει αλλαγή γραμμής μέσα σε παράγραφο;",
            options = listOf("<br>", "<hr>", "<p>", "<line>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_styles",
        title = "8. Στυλ με την ιδιότητα style",
        category = "HTML",
        description = "Με την ιδιότητα style αλλάζεις την εμφάνιση ενός στοιχείου. Γράφεις ζεύγη ιδιότητα: τιμή, και τα χωρίζεις με τον χαρακτήρα ; (ο οποίος στα αγγλικά λέγεται semicolon).\n\n" +
            "Χρήσιμες ιδιότητες: color (χρώμα κειμένου), background-color (χρώμα φόντου), font-size (μέγεθος), font-family (γραμματοσειρά) και text-align (στοίχιση).",
        codeExample = """
            <h1 style="color: blue;">Blue heading</h1>
            <p style="color: white; background-color: purple;">White text on purple</p>
            <p style="font-size: 24px; text-align: center;">Big centred text</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα CSS αλλάζει το χρώμα του φόντου;",
            options = listOf("color", "font-size", "background-color", "text-align"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_formatting",
        title = "9. Μορφοποίηση κειμένου",
        category = "HTML",
        description = "Μέσα σε μια παράγραφο μπορείς να δώσεις έμφαση. Το <strong> κάνει το κείμενο έντονο και δείχνει ότι είναι σημαντικό, το <em> το κάνει πλάγιο και το <mark> το τονίζει με κίτρινο φόντο.\n\n" +
            "Τα tags μπορούν να μπουν το ένα μέσα στο άλλο, αρκεί να κλείνουν με την ανάποδη σειρά από αυτή που άνοιξαν.",
        codeExample = """
            <p>Αυτό είναι <strong>σημαντικό</strong>.</p>
            <p>Αυτό έχει <em>έμφαση</em>.</p>
            <p>Αυτό είναι <mark>τονισμένο</mark>.</p>
            <p><strong><em>Και τα δύο μαζί</em></strong></p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag κάνει το κείμενο έντονο και σημαντικό;",
            options = listOf("<strong>", "<em>", "<mark>", "<small>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_quotations",
        title = "10. Παραθέσεις (blockquote, q, abbr)",
        category = "HTML",
        description = "Το <q> βάζει μια σύντομη παράθεση μέσα στο κείμενο, και ο browser προσθέτει εισαγωγικά. Το <blockquote> δείχνει μια μεγάλη παράθεση ως ξεχωριστό μπλοκ με εσοχή.\n\n" +
            "Το <abbr> δηλώνει συντομογραφία και με την ιδιότητα title δείχνει την πλήρη διατύπωση. Το <address> χρησιμοποιείται για στοιχεία επικοινωνίας και το <cite> για τον τίτλο ενός έργου.",
        codeExample = """
            <p>He said <q>learning is fun</q> yesterday.</p>
            <blockquote>A long quotation is shown as an indented block.</blockquote>
            <p><abbr title="HyperText Markup Language">HTML</abbr> is great.</p>
            <address>Jane Doe<br>Athens, Greece</address>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag δείχνει μια μεγάλη παράθεση ως μπλοκ με εσοχή;",
            options = listOf("<q>", "<abbr>", "<cite>", "<blockquote>"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_comments",
        title = "11. Σχόλια και ειδικοί χαρακτήρες",
        category = "HTML",
        description = "Τα σχόλια γράφονται ανάμεσα σε <!-- και --> και ο browser δεν τα εμφανίζει. Χρησιμεύουν για σημειώσεις μέσα στον κώδικα.\n\n" +
            "Οι χαρακτήρες < και > ανήκουν στη σύνταξη, οπότε για να τους εμφανίσεις γράφεις &lt; και &gt;. Το &amp; δίνει το & και το &copy; δίνει το σύμβολο ©.",
        codeExample = """
            <!-- Αυτό το σχόλιο δεν φαίνεται -->
            <p>Για να γράψεις ένα tag χρησιμοποίησε &lt;p&gt;.</p>
            <p>Tom &amp; Jerry</p>
            <p>&copy; 2026 Η σελίδα μου</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Πώς γράφεται ένα σχόλιο στην HTML;",
            options = listOf("<!-- σχόλιο -->", "// σχόλιο", "# σχόλιο", "/* σχόλιο */"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_colors",
        title = "12. Χρώματα",
        category = "HTML",
        description = "Στην HTML και το CSS τα χρώματα ορίζονται με διάφορους τρόπους: με όνομα (red, tomato), με HEX κωδικό (#ff0000), με RGB (rgb(255, 0, 0)) και με HSL (hsl(0, 100%, 50%)).\n\n" +
            "Ο HEX κωδικός ξεκινά με # και έχει τρία ζεύγη ψηφίων για το κόκκινο, το πράσινο και το μπλε. Μπορείς να τα εφαρμόσεις σε φόντο, κείμενο ή περίγραμμα.",
        codeExample = """
            <p style="background-color: tomato;">Name: tomato</p>
            <p style="background-color: #4caf50;">HEX: #4caf50</p>
            <p style="background-color: rgb(255, 193, 7);">RGB: rgb(255, 193, 7)</p>
            <p style="background-color: hsl(210, 80%, 60%);">HSL: hsl(210, 80%, 60%)</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο είναι έγκυρο χρώμα HEX;",
            options = listOf("#ff0000", "ff0000#", "#gg0000", "hex(255,0,0)"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_css",
        title = "13. Χρώματα και στυλ (CSS)",
        category = "HTML",
        description = "Η CSS είναι η γλώσσα που ορίζει την εμφάνιση. Ο πιο απλός τρόπος είναι η ιδιότητα style μέσα σε ένα tag, π.χ. style=\"color: red\".\n\n" +
            "Ένας κανόνας έχει ιδιότητα και τιμή, και πολλοί κανόνες χωρίζονται με ερωτηματικό: color (χρώμα κειμένου), background-color (φόντο), font-size (μέγεθος γραμματοσειράς). Για όλη τη σελίδα βάζεις ένα <style> με κανόνες για tags, π.χ. p { color: green; }.",
        codeExample = """
            <style>
              p { color: green; }
            </style>
            <h1 style="color: blue">Μπλε τίτλος</h1>
            <p>Πράσινη παράγραφος</p>
            <p style="background-color: yellow; font-size: 22px">Κίτρινο φόντο</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα CSS αλλάζει το χρώμα του κειμένου;",
            options = listOf("color", "background-color", "font-size", "text-style"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_links",
        title = "14. Σύνδεσμοι (a)",
        category = "HTML",
        description = "Το <a> (anchor) δημιουργεί σύνδεσμο. Η ιδιότητα href λέει πού πηγαίνει ο σύνδεσμος και το κείμενο ανάμεσα στα tags είναι αυτό που πατάει ο χρήστης.\n\n" +
            "Το href μπορεί να δείχνει σε άλλη ιστοσελίδα (https://...), σε άλλο αρχείο ή σε σημείο της ίδιας σελίδας. Η εφαρμογή δεν έχει internet, οπότε στην προεπισκόπηση οι σύνδεσμοι δεν ανοίγουν.",
        codeExample = """
            <p>Επισκέψου το <a href="https://www.wikipedia.org">Wikipedia</a>.</p>
            <p><a href="https://www.mozilla.org">Ένας δεύτερος σύνδεσμος</a></p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα ορίζει πού οδηγεί ένας σύνδεσμος;",
            options = listOf("href", "src", "alt", "title"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_images",
        title = "15. Εικόνες (img)",
        category = "HTML",
        description = "Το <img> εμφανίζει εικόνα. Δεν έχει tag κλεισίματος και χρειάζεται δύο ιδιότητες: src (η διαδρομή του αρχείου) και alt (εναλλακτικό κείμενο, που το διαβάζουν οι αναγνώστες οθόνης και φαίνεται αν η εικόνα δεν φορτώσει).\n\n" +
            "Μπορείς να ορίσεις μέγεθος με τις width και height. Στην προεπισκόπηση δεν υπάρχει πραγματικό αρχείο εικόνας, οπότε θα δεις μόνο το alt κείμενο.",
        codeExample = """
            <img src="cat.jpg" alt="Μια γάτα" width="200">
        """.trimIndent(),
        quiz = Quiz(
            question = "Σε τι χρησιμεύει η ιδιότητα alt;",
            options = listOf("Δείχνει εναλλακτικό κείμενο όταν η εικόνα δεν φαίνεται", "Ορίζει το μέγεθος της εικόνας", "Ορίζει τη διαδρομή του αρχείου", "Αλλάζει το χρώμα της εικόνας"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_favicon",
        title = "16. Favicon (εικονίδιο σελίδας)",
        category = "HTML",
        description = "Το favicon είναι το μικρό εικονίδιο που φαίνεται στην καρτέλα του browser, δίπλα στον τίτλο. Το ορίζεις με ένα <link rel=\"icon\"> μέσα στο <head>.\n\n" +
            "Το href δείχνει το αρχείο της εικόνας (συνήθως .ico ή .png). Στην προεπισκόπηση δεν υπάρχει καρτέλα, οπότε το εικονίδιο δεν φαίνεται, αλλά ο κώδικας είναι αυτός που θα χρησιμοποιούσες.",
        codeExample = """
            <head>
              <title>My page</title>
              <link rel="icon" type="image/png" href="favicon.png">
            </head>
            <body>
              <p>Look at the browser tab: the tiny icon is the favicon.</p>
            </body>
        """.trimIndent(),
        quiz = Quiz(
            question = "Πού μπαίνει το tag του favicon;",
            options = listOf("Μέσα στο <body>", "Μέσα στο <head>", "Μέσα στο <footer>", "Μέσα στο <title>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_title",
        title = "17. Τίτλος σελίδας (title)",
        category = "HTML",
        description = "Το <title> μπαίνει μέσα στο <head> και ορίζει τον τίτλο της σελίδας. Φαίνεται στην καρτέλα του browser, στους σελιδοδείκτες και ως τίτλος στα αποτελέσματα των μηχανών αναζήτησης.\n\n" +
            "Μην το μπερδεύεις με το <h1>: το <h1> είναι ο ορατός τίτλος μέσα στη σελίδα, ενώ το <title> φαίνεται έξω από αυτήν. Κάθε σελίδα πρέπει να έχει έναν περιγραφικό τίτλο.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <title>My first page - Codify</title>
            </head>
            <body>
              <h1>Visible heading</h1>
              <p>The title shows in the browser tab, not here.</p>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Πού εμφανίζεται το κείμενο του <title>;",
            options = listOf("Ως επικεφαλίδα στη σελίδα", "Στο υποσέλιδο", "Στην καρτέλα του browser", "Μέσα σε μια εικόνα"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_tables",
        title = "18. Πίνακες (table)",
        category = "HTML",
        description = "Ο πίνακας φτιάχνεται με <table>. Κάθε γραμμή είναι ένα <tr> (table row). Μέσα στη γραμμή, τα <th> είναι κελιά επικεφαλίδας (έντονα και κεντραρισμένα) και τα <td> είναι τα απλά κελιά δεδομένων.\n\n" +
            "Ο browser δεν βάζει περίγραμμα από μόνος του: το border=\"1\" στο <table> το προσθέτει γρήγορα.",
        codeExample = """
            <table border="1">
              <tr>
                <th>Όνομα</th>
                <th>Ηλικία</th>
              </tr>
              <tr>
                <td>Μαρία</td>
                <td>25</td>
              </tr>
              <tr>
                <td>Νίκος</td>
                <td>30</td>
              </tr>
            </table>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag ορίζει μια γραμμή πίνακα;",
            options = listOf("<tr>", "<td>", "<th>", "<row>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_lists",
        title = "19. Λίστες (ul, ol)",
        category = "HTML",
        description = "Οι λίστες οργανώνουν στοιχεία. Η <ul> (unordered list) φτιάχνει λίστα με κουκκίδες και η <ol> (ordered list) αριθμημένη λίστα. Κάθε στοιχείο μπαίνει σε ένα <li> (list item).\n\n" +
            "Το <li> μπαίνει πάντα μέσα σε <ul> ή <ol>. Μπορείς να βάλεις και λίστα μέσα σε στοιχείο λίστας για υπο-λίστες.",
        codeExample = """
            <ul>
              <li>Μήλα</li>
              <li>Μπανάνες</li>
            </ul>
            <ol>
              <li>Άνοιξε τον editor</li>
              <li>Γράψε HTML</li>
              <li>Δες το αποτέλεσμα</li>
            </ol>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag φτιάχνει αριθμημένη λίστα;",
            options = listOf("<ol>", "<ul>", "<li>", "<dl>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_blockinline",
        title = "20. Block και inline στοιχεία",
        category = "HTML",
        description = "Τα στοιχεία block (div, p, h1, ul) ξεκινούν σε νέα γραμμή και πιάνουν όλο το πλάτος που υπάρχει. Τα inline στοιχεία (span, a, b, img) πιάνουν μόνο όσο χώρο χρειάζονται και μένουν στην ίδια γραμμή με το κείμενο.\n\n" +
            "Με το CSS μπορείς να αλλάξεις τη συμπεριφορά με την ιδιότητα display, π.χ. display: inline ή display: block.",
        codeExample = """
            <div style="background: lightblue;">Block 1 (div)</div>
            <div style="background: lightgreen;">Block 2 (div)</div>
            <span style="background: khaki;">Inline 1</span>
            <span style="background: pink;">Inline 2</span>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο από τα παρακάτω είναι inline στοιχείο;",
            options = listOf("<div>", "<p>", "<h1>", "<span>"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_divspan",
        title = "21. Ομαδοποίηση (div και span)",
        category = "HTML",
        description = "Το <div> είναι ένα «κουτί» που ομαδοποιεί στοιχεία και πιάνει ολόκληρη τη γραμμή (block). Το <span> ομαδοποιεί ένα κομμάτι κειμένου μέσα στη γραμμή (inline).\n\n" +
            "Μόνα τους δεν αλλάζουν την εμφάνιση, αλλά τα χρησιμοποιούμε μαζί με ιδιότητες και CSS για να μορφοποιήσουμε μια ομάδα στοιχείων.",
        codeExample = """
            <div style="border: 2px solid blue; padding: 10px">
              <p>Είμαι μέσα σε ένα div.</p>
              <p>Αυτή η λέξη είναι <span style="color: red">κόκκινη</span>.</p>
            </div>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια είναι η διαφορά του span από το div;",
            options = listOf("Το span ομαδοποιεί κείμενο μέσα στη γραμμή, ενώ το div πιάνει ολόκληρη γραμμή", "Δεν υπάρχει διαφορά", "Το span φτιάχνει πίνακα", "Το div είναι μόνο για εικόνες"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_classes",
        title = "22. Κλάσεις (class)",
        category = "HTML",
        description = "Η ιδιότητα class δίνει σε στοιχεία ένα κοινό όνομα, ώστε να τους εφαρμόζεις το ίδιο στυλ. Στο CSS επιλέγεις μια κλάση γράφοντας τελεία πριν το όνομα, π.χ. .note.\n\n" +
            "Ένα στοιχείο μπορεί να έχει πολλές κλάσεις, χωρισμένες με κενό, και πολλά στοιχεία μπορούν να έχουν την ίδια κλάση.",
        codeExample = """
            <style>
              .note { color: white; background: teal; padding: 8px; }
              .big { font-size: 24px; }
            </style>
            <p class="note">A note</p>
            <p class="note big">A big note</p>
            <p>A normal paragraph</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Πώς επιλέγεις στο CSS την κλάση «note»;",
            options = listOf(".note", "#note", "note", "*note"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_id",
        title = "23. Αναγνωριστικά (id)",
        category = "HTML",
        description = "Η ιδιότητα id δίνει ένα μοναδικό όνομα σε ένα στοιχείο. Σε κάθε σελίδα δεν επιτρέπεται να υπάρχουν δύο στοιχεία με το ίδιο id. Στο CSS το επιλέγεις με #, π.χ. #title.\n\n" +
            "Το id χρησιμεύει και για σύνδεσμο προς συγκεκριμένο σημείο της σελίδας (href=\"#bottom\") και για να βρίσκει η JavaScript το στοιχείο.",
        codeExample = """
            <style>
              #main-title { color: crimson; }
            </style>
            <h1 id="main-title">A unique title</h1>
            <p><a href="#bottom">Jump to the bottom</a></p>
            <p id="bottom">Bottom paragraph (id="bottom")</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι ισχύει για το id;",
            options = listOf("Μπορεί να το έχουν πολλά στοιχεία", "Πρέπει να είναι μοναδικό στη σελίδα", "Γράφεται με τελεία στο CSS", "Μπαίνει μόνο σε εικόνες"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_buttons",
        title = "24. Κουμπιά (button)",
        category = "HTML",
        description = "Το <button> φτιάχνει κουμπί που μπορεί να πατηθεί. Με την ιδιότητα type ορίζεις τη δράση: submit (στέλνει τη φόρμα), button (δεν κάνει τίποτα μόνο του) ή reset.\n\n" +
            "Μπορείς να το στυλιζάρεις με CSS (χρώμα, γωνίες, περιθώρια) και να το απενεργοποιήσεις με την ιδιότητα disabled. Συχνά του δίνεις δράση με JavaScript.",
        codeExample = """
            <button>Default</button>
            <button type="button" style="background: seagreen; color: white; padding: 8px 16px; border: none; border-radius: 8px;">Styled</button>
            <button disabled>Disabled</button>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα απενεργοποιεί ένα κουμπί;",
            options = listOf("off", "hidden", "disabled", "readonly"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_iframes",
        title = "25. Ενσωμάτωση σελίδας (iframe)",
        category = "HTML",
        description = "Το <iframe> ενσωματώνει μια άλλη ιστοσελίδα μέσα στη δική σου. Ορίζεις τη διεύθυνση με το src, το μέγεθος με width και height και μια περιγραφή με το title.\n\n" +
            "Εδώ χρησιμοποιούμε την ιδιότητα srcdoc, που βάζει το περιεχόμενο κατευθείαν στον κώδικα, ώστε το παράδειγμα να δουλεύει χωρίς σύνδεση στο διαδίκτυο.",
        codeExample = """
            <iframe
              srcdoc="<h2>Inside the iframe</h2><p>A page inside a page.</p>"
              width="300" height="140" title="Demo"></iframe>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag ενσωματώνει μια άλλη σελίδα;",
            options = listOf("<embed-page>", "<include>", "<frame-set>", "<iframe>"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_javascript",
        title = "26. JavaScript στην HTML",
        category = "HTML",
        description = "Η JavaScript κάνει τις σελίδες διαδραστικές. Ο κώδικάς της μπαίνει μέσα στο <script>. Μπορεί να βρει ένα στοιχείο με το id του (getElementById) και να αλλάξει το περιεχόμενό του.\n\n" +
            "Με ιδιότητες όπως το onclick τρέχεις κώδικα όταν ο χρήστης πατά ένα στοιχείο. Πάτα το κουμπί στην προεπισκόπηση.",
        codeExample = """
            <p id="demo">Press the button.</p>
            <button onclick="sayHi()">Click me</button>
            <script>
              function sayHi() {
                document.getElementById("demo").textContent = "Hello from JavaScript!";
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Μέσα σε ποιο tag μπαίνει ο κώδικας JavaScript;",
            options = listOf("<script>", "<js>", "<code>", "<javascript>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_filepaths",
        title = "27. Διαδρομές αρχείων",
        category = "HTML",
        description = "Η διαδρομή (path) λέει στον browser πού βρίσκεται ένα αρχείο, π.χ. μια εικόνα. Αν είναι στον ίδιο φάκελο γράφεις μόνο το όνομα (pic.jpg), αν είναι σε υποφάκελο γράφεις images/pic.jpg και αν είναι ένα επίπεδο πιο πάνω γράφεις ../pic.jpg.\n\n" +
            "Μια πλήρης διεύθυνση (https://example.com/pic.jpg) λέγεται απόλυτη διαδρομή. Στην προεπισκόπηση δεν υπάρχουν αρχεία, οπότε θα δεις μόνο το alt κείμενο.",
        codeExample = """
            <img src="pic.jpg" alt="Same folder">
            <img src="images/pic.jpg" alt="Inside the images folder">
            <img src="../pic.jpg" alt="One folder up">
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι σημαίνει το ../ σε μια διαδρομή;",
            options = listOf("Ο φάκελος μέσα στον τρέχοντα", "Ένας φάκελος πιο πάνω", "Η αρχική σελίδα του site", "Διαγραφή του αρχείου"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_head",
        title = "28. Το στοιχείο head",
        category = "HTML",
        description = "Το <head> περιέχει πληροφορίες για τη σελίδα που δεν εμφανίζονται στο σώμα της. Εκεί μπαίνουν το <title>, το <meta> (π.χ. κωδικοποίηση, περιγραφή, viewport), το <style> και οι σύνδεσμοι <link> προς αρχεία CSS ή εικονίδια.\n\n" +
            "Το μόνο που φαίνεται από το head είναι ο τίτλος στην καρτέλα. Όλο το ορατό περιεχόμενο μπαίνει στο <body>.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="UTF-8">
              <meta name="viewport" content="width=device-width, initial-scale=1">
              <meta name="description" content="A short page description">
              <title>Head demo</title>
              <style>body { font-family: sans-serif; }</style>
            </head>
            <body>
              <h1>Only the body is visible</h1>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο στοιχείο ΔΕΝ μπαίνει συνήθως μέσα στο <head>;",
            options = listOf("<title>", "<meta>", "<p>", "<style>"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_layout",
        title = "29. Διάταξη σελίδας (layout)",
        category = "HTML",
        description = "Μια σελίδα συνήθως χωρίζεται σε κεφαλίδα, μενού, κύριο περιεχόμενο και υποσέλιδο. Με τα σημασιολογικά tags δίνεις νόημα σε κάθε περιοχή και με το CSS τις τοποθετείς.\n\n" +
            "Το πιο εύκολο εργαλείο είναι το flexbox: με το display: flex τα παιδιά ενός στοιχείου μπαίνουν δίπλα δίπλα και με το flex ορίζεις πόσο πλάτος παίρνει το καθένα.",
        codeExample = """
            <style>
              header, footer { background: #333; color: white; padding: 8px; text-align: center; }
              .wrap { display: flex; gap: 8px; margin: 8px 0; }
              .menu { flex: 1; background: #ddd; padding: 8px; }
              .content { flex: 3; background: #eee; padding: 8px; }
            </style>
            <header>Header</header>
            <div class="wrap">
              <nav class="menu">Menu</nav>
              <main class="content">Content</main>
            </div>
            <footer>Footer</footer>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια δήλωση CSS βάζει τα στοιχεία δίπλα δίπλα με flexbox;",
            options = listOf("float: none;", "position: flex;", "layout: row;", "display: flex;"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_responsive",
        title = "30. Responsive σχεδίαση",
        category = "HTML",
        description = "Μια responsive σελίδα προσαρμόζεται σε κάθε οθόνη, από κινητό έως υπολογιστή. Το πρώτο βήμα είναι το meta viewport μέσα στο <head>. Το δεύτερο είναι να μη βάζεις σταθερά πλάτη: χρησιμοποίησε max-width: 100% για εικόνες και grid ή flex για διάταξη.\n\n" +
            "Εδώ το grid με repeat(auto-fit, minmax(120px, 1fr)) βάζει όσες στήλες χωράνε. Στένεψε ή γύρισε την οθόνη για να δεις τις αλλαγές.",
        codeExample = """
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <style>
              .grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(120px, 1fr)); gap: 8px; }
              .box { background: #4db6ac; padding: 16px; text-align: center; }
              img { max-width: 100%; }
            </style>
            <div class="grid">
              <div class="box">1</div>
              <div class="box">2</div>
              <div class="box">3</div>
              <div class="box">4</div>
            </div>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο meta tag βοηθά τη σελίδα να προσαρμόζεται στα κινητά;",
            options = listOf("viewport", "charset", "description", "author"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_computercode",
        title = "31. Κώδικας υπολογιστή",
        category = "HTML",
        description = "Η HTML έχει ειδικά tags για κείμενο σχετικό με υπολογιστές: το <code> για κώδικα, το <kbd> για πλήκτρα, το <samp> για έξοδο προγράμματος και το <var> για μεταβλητές. Όλα εμφανίζονται με γραμματοσειρά σταθερού πλάτους.\n\n" +
            "Το <pre> διατηρεί τα κενά και τις αλλαγές γραμμής όπως τα έγραψες, ώστε να δείχνεις κώδικα πολλών γραμμών.",
        codeExample = """
            <p>Use <code>print()</code> to show text.</p>
            <p>Press <kbd>Ctrl</kbd> + <kbd>S</kbd> to save.</p>
            <p>Output: <samp>Hello</samp></p>
            <p>Formula: <var>x</var> = 5</p>
            <pre>
            Line 1
                Line 2 keeps its spaces
            </pre>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag διατηρεί τα κενά και τις αλλαγές γραμμής;",
            options = listOf("<code>", "<pre>", "<samp>", "<var>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_semantic",
        title = "32. Σημασιολογικά στοιχεία",
        category = "HTML",
        description = "Αντί να βάζουμε παντού <div>, υπάρχουν tags που δείχνουν τον ρόλο κάθε περιοχής: <header> (κεφαλίδα), <nav> (μενού πλοήγησης), <main> (κύριο περιεχόμενο), <section> (ενότητα) και <footer> (υποσέλιδο).\n\n" +
            "Δεν αλλάζουν την εμφάνιση, αλλά βοηθούν τις μηχανές αναζήτησης, τους αναγνώστες οθόνης και εσένα να διαβάζεις τον κώδικα.",
        codeExample = """
            <header><h1>Το Blog μου</h1></header>
            <nav><a href="#">Αρχική</a> | <a href="#">Επικοινωνία</a></nav>
            <main>
              <section><p>Το κύριο περιεχόμενο.</p></section>
            </main>
            <footer><p>Υποσέλιδο</p></footer>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag ορίζει το υποσέλιδο μιας σελίδας;",
            options = listOf("<footer>", "<header>", "<main>", "<nav>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_styleguide",
        title = "33. Οδηγός γραφής HTML",
        category = "HTML",
        description = "Ο καθαρός κώδικας διαβάζεται και συντηρείται εύκολα. Δήλωσε πάντα <!DOCTYPE html> και τη γλώσσα με <html lang=\"el\">. Γράφε tags και ιδιότητες με μικρά γράμματα, κλείνε όλα τα στοιχεία και βάζε τις τιμές των ιδιοτήτων σε εισαγωγικά.\n\n" +
            "Βάζε πάντα alt στις εικόνες, χρησιμοποίησε εσοχές για να φαίνεται η δομή και δώσε στο αρχείο όνομα με μικρά γράμματα χωρίς κενά, π.χ. my-page.html.",
        codeExample = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
              <meta charset="UTF-8">
              <title>Style guide</title>
            </head>
            <body>
              <h1>Clean code</h1>
              <img src="cat.jpg" alt="A cat">
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα του <html> δηλώνει τη γλώσσα της σελίδας;",
            options = listOf("language", "locale", "lang", "type"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_entities",
        title = "34. Entities και σύμβολα",
        category = "HTML",
        description = "Οι entities είναι κωδικοί που αρχίζουν με & και τελειώνουν με ;. Τις χρησιμοποιείς για χαρακτήρες που ανήκουν στη σύνταξη (&lt; &gt; &amp;), για το σκληρό κενό &nbsp; και για σύμβολα όπως &copy; &euro; &hearts;.\n\n" +
            "Μπορείς να γράψεις έναν χαρακτήρα και με τον αριθμό του, π.χ. &#9731; ή &#x2605;. Έτσι βάζεις σύμβολα που δεν υπάρχουν στο πληκτρολόγιο.",
        codeExample = """
            <p>5 &lt; 10 and 10 &gt; 5</p>
            <p>&copy; 2026 &mdash; All rights reserved</p>
            <p>Price: 20&euro; &nbsp;&nbsp; Love: &hearts;</p>
            <p>By number: &#9731; &#x2605;</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια entity εμφανίζει το σύμβολο <;",
            options = listOf("&gt;", "&amp;", "&nbsp;", "&lt;"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_emojis",
        title = "35. Emojis",
        category = "HTML",
        description = "Τα emojis είναι απλοί χαρακτήρες Unicode, οπότε τα βάζεις στη σελίδα σαν κανονικό κείμενο. Για να εμφανίζονται σωστά, η σελίδα πρέπει να χρησιμοποιεί την κωδικοποίηση UTF-8: <meta charset=\"UTF-8\">.\n\n" +
            "Μπορείς να τα γράψεις είτε απευθείας είτε με τον αριθμό τους, π.χ. &#128512;. Αυξάνοντας το font-size γίνονται μεγαλύτερα.",
        codeExample = """
            <meta charset="UTF-8">
            <p style="font-size: 32px;">😀 😍 🚀</p>
            <p style="font-size: 32px;">&#128512; &#128640; &#127775;</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια κωδικοποίηση χρειάζεται για να δουλεύουν σωστά τα emojis;",
            options = listOf("UTF-8", "ASCII", "Binary", "Base-10"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_charsets",
        title = "36. Σύνολα χαρακτήρων (charset)",
        category = "HTML",
        description = "Ο browser πρέπει να ξέρει με ποιον κώδικα να διαβάσει τους χαρακτήρες του αρχείου. Το ορίζεις με <meta charset=\"UTF-8\"> μέσα στο <head>.\n\n" +
            "Το UTF-8 είναι το σύγχρονο πρότυπο και περιέχει σχεδόν όλους τους χαρακτήρες του κόσμου: ελληνικά, λατινικά, κινεζικά, emoji. Παλιότερα σύνολα, όπως το ASCII και το ISO-8859-1, έχουν πολύ λιγότερους χαρακτήρες.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="UTF-8">
              <title>Charset</title>
            </head>
            <body>
              <p>Ελληνικά, café, 日本語, 😀</p>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο σύνολο χαρακτήρων συνιστάται σήμερα;",
            options = listOf("ASCII", "UTF-8", "ISO-8859-1", "Windows-1252"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_urlencode",
        title = "37. Κωδικοποίηση URL",
        category = "HTML",
        description = "Οι διευθύνσεις URL επιτρέπεται να έχουν μόνο συγκεκριμένους χαρακτήρες. Οι υπόλοιποι αντικαθίστανται από το σύμβολο % και έναν κωδικό. Για παράδειγμα, το κενό γίνεται %20 και το & γίνεται %26.\n\n" +
            "Η JavaScript έχει τη συνάρτηση encodeURIComponent, που κάνει τη μετατροπή. Την χρησιμοποιείς όταν βάζεις κείμενο του χρήστη μέσα σε μια διεύθυνση.",
        codeExample = """
            <p id="out"></p>
            <script>
              var text = "Hello world & café";
              document.getElementById("out").textContent = encodeURIComponent(text);
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Σε τι μετατρέπεται ένα κενό σε μια διεύθυνση URL;",
            options = listOf("%00", "&nbsp;", "%20", "%space"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_xhtml",
        title = "38. HTML και XHTML",
        category = "HTML",
        description = "Η XHTML είναι μια αυστηρότερη εκδοχή της HTML, βασισμένη στην XML. Απαιτεί tags και ιδιότητες με μικρά γράμματα, όλα τα στοιχεία κλεισμένα, τιμές ιδιοτήτων σε εισαγωγικά και σωστή ένθεση.\n\n" +
            "Στα κενά στοιχεία το κλείσιμο γράφεται με κάθετο στο τέλος, π.χ. <br />. Η σύγχρονη HTML είναι πιο ελαστική, αλλά το να γράφεις καθαρό κώδικα σαν την XHTML είναι καλή συνήθεια.",
        codeExample = """
            <p>XHTML style:</p>
            <br />
            <img src="cat.jpg" alt="A cat" />
            <input type="text" value="Hello" />
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι απαιτεί η XHTML σε σχέση με την HTML;",
            options = listOf("Να μην υπάρχουν εικόνες", "Να γράφονται όλα με κεφαλαία", "Να μην υπάρχει CSS", "Να κλείνουν όλα τα στοιχεία"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_forms",
        title = "39. Φόρμες (form, input)",
        category = "HTML",
        description = "Οι φόρμες μαζεύουν δεδομένα από τον χρήστη. Το <form> περιέχει τα πεδία. Το <input> φτιάχνει πεδίο και το είδος του το ορίζει η ιδιότητα type: text, password, email, checkbox και άλλα.\n\n" +
            "Το <label> δίνει όνομα στο πεδίο και το <button> φτιάχνει κουμπί. Στην προεπισκόπηση η φόρμα δεν στέλνεται πουθενά, εμφανίζεται μόνο.",
        codeExample = """
            <form>
              <label>Όνομα: <input type="text"></label>
              <br>
              <label>Email: <input type="email"></label>
              <br>
              <label><input type="checkbox"> Θέλω ενημερώσεις</label>
              <br>
              <button>Αποστολή</button>
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα ορίζει το είδος ενός πεδίου input;",
            options = listOf("type", "kind", "form", "label"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_formattrs",
        title = "40. Ιδιότητες φόρμας",
        category = "HTML",
        description = "Η ιδιότητα action ορίζει πού θα σταλούν τα δεδομένα της φόρμας και η method πώς: get (μέσα στη διεύθυνση) ή post (κρυφά στο σώμα του αιτήματος). Με το target ορίζεις πού θα ανοίξει η απάντηση.\n\n" +
            "Με autocomplete=\"off\" ο browser δεν προτείνει παλιές τιμές και με novalidate η φόρμα στέλνεται χωρίς έλεγχο. Τα πεδία χρειάζονται name για να σταλούν.",
        codeExample = """
            <form action="/submit" method="post" autocomplete="off">
              <label>Name: <input type="text" name="username"></label>
              <br>
              <button type="submit">Send</button>
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα ορίζει πού στέλνονται τα δεδομένα μιας φόρμας;",
            options = listOf("action", "target-url", "send", "method"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_formelements",
        title = "41. Στοιχεία φόρμας",
        category = "HTML",
        description = "Εκτός από το <input>, οι φόρμες έχουν και άλλα στοιχεία: το <select> με τα <option> φτιάχνει αναπτυσσόμενη λίστα, το <textarea> πεδίο για πολλές γραμμές και το <fieldset> με το <legend> ομαδοποιεί πεδία.\n\n" +
            "Το <label> με την ιδιότητα for συνδέεται με ένα πεδίο μέσω του id του, ώστε το πάτημα του κειμένου να επιλέγει το πεδίο.",
        codeExample = """
            <form>
              <label for="c">Country:</label>
              <select id="c">
                <option>Greece</option>
                <option>Cyprus</option>
              </select>
              <br>
              <textarea rows="2" cols="20">Your message</textarea>
              <fieldset>
                <legend>Choose</legend>
                <label><input type="radio" name="r"> A</label>
                <label><input type="radio" name="r"> B</label>
              </fieldset>
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο στοιχείο φτιάχνει αναπτυσσόμενη λίστα;",
            options = listOf("<list>", "<select>", "<dropdown>", "<textarea>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_inputtypes",
        title = "42. Τύποι input",
        category = "HTML",
        description = "Η ιδιότητα type αλλάζει τελείως τη συμπεριφορά του <input>. Μερικοί τύποι: text (κείμενο), password (κρύβει τους χαρακτήρες), email, number (αριθμός), date (ημερομηνία), color (επιλογή χρώματος), range (ρυθμιστικό), checkbox, radio και file.\n\n" +
            "Οι σύγχρονοι browsers δείχνουν κατάλληλο πληκτρολόγιο ή παράθυρο επιλογής για κάθε τύπο και ελέγχουν αυτόματα τις τιμές.",
        codeExample = """
            <form>
              <input type="password" placeholder="Password"><br>
              <input type="number" value="5"><br>
              <input type="date"><br>
              <input type="color" value="#ff5722"><br>
              <input type="range" min="0" max="10"><br>
              <label><input type="checkbox"> I agree</label>
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο type κρύβει τους χαρακτήρες που πληκτρολογείς;",
            options = listOf("secret", "hidden-text", "password", "text"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_inputattrs",
        title = "43. Ιδιότητες input",
        category = "HTML",
        description = "Οι ιδιότητες του <input> ρυθμίζουν το πεδίο: value (αρχική τιμή), placeholder (υπόδειξη μέσα στο κενό πεδίο), required (υποχρεωτικό), readonly (μόνο ανάγνωση), disabled (ανενεργό), maxlength (μέγιστοι χαρακτήρες), min και max (όρια αριθμών) και autofocus.\n\n" +
            "Το pattern δέχεται μια κανονική έκφραση για έλεγχο της τιμής, π.χ. pattern=\"[0-9]{4}\" για τέσσερα ψηφία.",
        codeExample = """
            <form>
              <input type="text" placeholder="Your name" required><br>
              <input type="text" value="Read only" readonly><br>
              <input type="text" maxlength="5" placeholder="Max 5 chars"><br>
              <input type="number" min="1" max="10" value="3">
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα δείχνει υπόδειξη μέσα σε ένα κενό πεδίο;",
            options = listOf("value-hint", "tooltip", "label", "placeholder"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_inputformattrs",
        title = "44. Ιδιότητες φόρμας στο input",
        category = "HTML",
        description = "Ένα κουμπί ή πεδίο μπορεί να αλλάξει τη συμπεριφορά της φόρμας με δικές του ιδιότητες: formaction (άλλη διεύθυνση αποστολής), formmethod (άλλη μέθοδος), formtarget και formnovalidate.\n\n" +
            "Η ιδιότητα form συνδέει ένα πεδίο με μια φόρμα μέσω του id της, ακόμα κι αν το πεδίο βρίσκεται έξω από το <form>.",
        codeExample = """
            <form id="myform" action="/save" method="post">
              <input type="text" name="n">
              <button type="submit">Save</button>
              <button type="submit" formaction="/preview" formmethod="get">Preview</button>
            </form>
            <input type="text" form="myform" placeholder="Outside, but in the form">
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι κάνει η ιδιότητα formaction σε ένα κουμπί;",
            options = listOf("Αλλάζει τη διεύθυνση αποστολής μόνο για αυτό το κουμπί", "Αλλάζει το χρώμα του κουμπιού", "Διαγράφει τη φόρμα", "Κρύβει το κουμπί"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_canvas",
        title = "45. Καμβάς (canvas)",
        category = "HTML",
        description = "Το <canvas> είναι μια επιφάνεια ζωγραφικής. Από μόνο του είναι άδειο: τα σχήματα τα ζωγραφίζεις με JavaScript. Παίρνεις το «πινέλο» με getContext(\"2d\") και μετά χρησιμοποιείς εντολές όπως fillRect (ορθογώνιο) και arc (κύκλος).\n\n" +
            "Το fillStyle ορίζει το χρώμα. Οι συντεταγμένες ξεκινούν από την πάνω αριστερή γωνία (0, 0).",
        codeExample = """
            <canvas id="c" width="200" height="100" style="border: 1px solid #888;"></canvas>
            <script>
              var ctx = document.getElementById("c").getContext("2d");
              ctx.fillStyle = "tomato";
              ctx.fillRect(20, 20, 80, 50);
              ctx.beginPath();
              ctx.arc(150, 50, 30, 0, 2 * Math.PI);
              ctx.fillStyle = "royalblue";
              ctx.fill();
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag ορίζει την επιφάνεια ζωγραφικής;",
            options = listOf("<paint>", "<canvas>", "<draw>", "<svg-area>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_svg",
        title = "46. Γραφικά SVG",
        category = "HTML",
        description = "Το SVG (Scalable Vector Graphics) σχεδιάζει διανυσματικά γραφικά με κώδικα. Βάζεις το <svg> κατευθείαν στη σελίδα και μέσα του σχήματα όπως <rect> (ορθογώνιο), <circle> (κύκλος), <line> και <text>.\n\n" +
            "Τα διανυσματικά γραφικά δεν χάνουν ποιότητα όσο κι αν μεγαλώσουν. Αυτό τα κάνει ιδανικά για εικονίδια και λογότυπα.",
        codeExample = """
            <svg width="200" height="100">
              <rect x="10" y="10" width="80" height="60" fill="tomato" />
              <circle cx="150" cy="50" r="30" fill="royalblue" />
              <text x="10" y="90" fill="black">SVG</text>
            </svg>
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι είναι ιδιαίτερο στα γραφικά SVG;",
            options = listOf("Λειτουργούν μόνο σε κινητά", "Δεν μπορούν να έχουν χρώμα", "Δεν χάνουν ποιότητα όταν μεγαλώνουν", "Χρειάζονται πάντα αρχείο εικόνας"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_media",
        title = "47. Πολυμέσα (media)",
        category = "HTML",
        description = "Η HTML μπορεί να παίξει βίντεο και ήχο χωρίς πρόσθετα, με τα tags <video> και <audio>. Οι browsers υποστηρίζουν συγκεκριμένες μορφές: MP4, WebM και Ogg για βίντεο, MP3, WAV και Ogg για ήχο.\n\n" +
            "Με περισσότερα <source> μέσα στο ίδιο στοιχείο δίνεις εναλλακτικές μορφές και ο browser διαλέγει την πρώτη που υποστηρίζει. Δεν υπάρχουν αρχεία πολυμέσων στην προεπισκόπηση, οπότε βλέπεις μόνο τα χειριστήρια.",
        codeExample = """
            <video width="260" controls>
              <source src="movie.mp4" type="video/mp4">
              Your browser does not support video.
            </video>
            <br>
            <audio controls>
              <source src="sound.mp3" type="audio/mpeg">
              Your browser does not support audio.
            </audio>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια μορφή ήχου υποστηρίζουν οι browsers;",
            options = listOf("DOCX", "PSD", "EXE", "MP3"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_video",
        title = "48. Βίντεο (video)",
        category = "HTML",
        description = "Το <video> εμφανίζει ένα βίντεο. Η ιδιότητα controls προσθέτει κουμπιά αναπαραγωγής, ένταση και πλήρη οθόνη. Με width και height ορίζεις το μέγεθος.\n\n" +
            "Με το autoplay ξεκινά μόνο του (συνήθως μαζί με muted) και με το loop επαναλαμβάνεται. Το κείμενο μέσα στο tag φαίνεται μόνο αν ο browser δεν υποστηρίζει βίντεο.",
        codeExample = """
            <video width="280" controls>
              <source src="movie.mp4" type="video/mp4">
              <source src="movie.webm" type="video/webm">
              Your browser does not support video.
            </video>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα εμφανίζει τα κουμπιά αναπαραγωγής;",
            options = listOf("controls", "buttons", "play", "show"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_audio",
        title = "49. Ήχος (audio)",
        category = "HTML",
        description = "Το <audio> παίζει ήχο, π.χ. μουσική ή ηχογράφηση. Με το controls εμφανίζονται τα κουμπιά αναπαραγωγής. Το <source> ορίζει το αρχείο και τον τύπο του (audio/mpeg για MP3).\n\n" +
            "Με το loop ο ήχος επαναλαμβάνεται συνέχεια και με το muted ξεκινά σιωπηλός. Οι περισσότεροι browsers δεν αφήνουν αυτόματη αναπαραγωγή ήχου χωρίς κίνηση του χρήστη.",
        codeExample = """
            <audio controls loop>
              <source src="sound.mp3" type="audio/mpeg">
              <source src="sound.ogg" type="audio/ogg">
              Your browser does not support audio.
            </audio>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα κάνει τον ήχο να επαναλαμβάνεται;",
            options = listOf("repeat", "loop", "again", "cycle"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_youtube",
        title = "50. Βίντεο YouTube",
        category = "HTML",
        description = "Για να βάλεις βίντεο από το YouTube στη σελίδα σου, χρησιμοποίησε ένα <iframe>. Στο src γράφεις τη διεύθυνση https://www.youtube.com/embed/ και στο τέλος το αναγνωριστικό του βίντεο (το κομμάτι μετά το v= στη διεύθυνσή του).\n\n" +
            "Με την ιδιότητα allowfullscreen επιτρέπεις πλήρη οθόνη. Η προεπισκόπηση δεν έχει πρόσβαση στο διαδίκτυο, οπότε το βίντεο δεν θα φορτώσει εδώ.",
        codeExample = """
            <iframe width="280" height="160"
              src="https://www.youtube.com/embed/VIDEO_ID"
              title="YouTube video" allowfullscreen></iframe>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag χρησιμοποιείς για να ενσωματώσεις βίντεο YouTube;",
            options = listOf("<youtube>", "<video-link>", "<iframe>", "<embed-yt>"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_webapis",
        title = "51. Εισαγωγή στα Web APIs",
        category = "HTML",
        description = "Τα Web APIs είναι έτοιμες λειτουργίες του browser που χρησιμοποιείς με JavaScript: εντοπισμός τοποθεσίας, αποθήκευση δεδομένων, σύρσιμο στοιχείων, εργασίες στο παρασκήνιο και άλλα. Δεν χρειάζεται να τα εγκαταστήσεις.\n\n" +
            "Πριν χρησιμοποιήσεις ένα API, καλό είναι να ελέγχεις αν το υποστηρίζει ο browser. Το παράδειγμα δείχνει ποια από αυτά είναι διαθέσιμα εδώ.",
        codeExample = """
            <p id="out"></p>
            <script>
              var apis = [];
              if ("geolocation" in navigator) apis.push("Geolocation");
              if ("localStorage" in window) apis.push("Web Storage");
              if (window.Worker) apis.push("Web Workers");
              if (window.EventSource) apis.push("Server-Sent Events");
              document.getElementById("out").textContent = "Available: " + apis.join(", ");
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι είναι ένα Web API;",
            options = listOf("Ένα είδος εικόνας", "Ένας διακομιστής βάσης δεδομένων", "Ένα πρόγραμμα επεξεργασίας κειμένου", "Μια έτοιμη λειτουργία του browser που καλείς με JavaScript"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_geolocation",
        title = "52. Geolocation API",
        category = "HTML",
        description = "Το Geolocation API βρίσκει τη θέση του χρήστη. Καλείς τη navigator.geolocation.getCurrentPosition, που παίρνει δύο συναρτήσεις: μία για την επιτυχία (με το αντικείμενο pos, που περιέχει coords.latitude και coords.longitude) και μία για το σφάλμα.\n\n" +
            "Ο browser ζητά πάντα την άδεια του χρήστη. Στην προεπισκόπηση της εφαρμογής η άδεια πιθανότατα δεν δίνεται και θα δεις το μήνυμα σφάλματος, που είναι κι αυτό ένα σωστό αποτέλεσμα.",
        codeExample = """
            <button onclick="getLocation()">Where am I?</button>
            <p id="out"></p>
            <script>
              function getLocation() {
                var out = document.getElementById("out");
                if (!navigator.geolocation) { out.textContent = "Not supported."; return; }
                navigator.geolocation.getCurrentPosition(
                  function (pos) { out.textContent = pos.coords.latitude + ", " + pos.coords.longitude; },
                  function (err) { out.textContent = "Error: " + err.message; }
                );
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια μέθοδος βρίσκει την τρέχουσα θέση;",
            options = listOf("getCurrentPosition", "findMe", "locate", "getPlace"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_dragdrop",
        title = "53. Drag and Drop API",
        category = "HTML",
        description = "Για να γίνει ένα στοιχείο σύρσιμο, του βάζεις draggable=\"true\". Η περιοχή που το δέχεται ακούει τα γεγονότα dragover και drop. Στο dragover πρέπει να καλέσεις preventDefault(), αλλιώς δεν επιτρέπεται η απόθεση.\n\n" +
            "Στο drop μετακινείς το στοιχείο με appendChild. Σημείωση: σε οθόνες αφής το σύρσιμο με αυτό το API μπορεί να μη δουλεύει σε όλους τους browsers.",
        codeExample = """
            <style>
              #box { width: 80px; height: 60px; background: orange; }
              #zone { width: 180px; height: 100px; margin-top: 8px; border: 2px dashed #888; }
            </style>
            <div id="box" draggable="true">Drag me</div>
            <div id="zone">Drop here</div>
            <script>
              var box = document.getElementById("box");
              var zone = document.getElementById("zone");
              zone.addEventListener("dragover", function (e) { e.preventDefault(); });
              zone.addEventListener("drop", function (e) {
                e.preventDefault();
                zone.appendChild(box);
              });
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα κάνει ένα στοιχείο σύρσιμο;",
            options = listOf("movable=\"yes\"", "draggable=\"true\"", "drag=\"on\"", "dropzone=\"true\""),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_popover",
        title = "54. Popover API",
        category = "HTML",
        description = "Το Popover API φτιάχνει αναδυόμενα παράθυρα χωρίς JavaScript. Βάζεις στο στοιχείο την ιδιότητα popover και σε ένα κουμπί την popovertarget με το id του. Το πάτημα ανοίγει και κλείνει το παράθυρο.\n\n" +
            "Το κλείνεις και πατώντας έξω από αυτό ή με το πλήκτρο Esc. Αν η έκδοση του WebView της συσκευής σου είναι παλιά, μπορεί να μη λειτουργεί.",
        codeExample = """
            <button popovertarget="info">Show info</button>
            <div id="info" popover style="padding: 16px;">
              Hello! I am a popover.<br>Click outside to close me.
            </div>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποια ιδιότητα μετατρέπει ένα στοιχείο σε popover;",
            options = listOf("popup", "overlay", "popover", "float"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_webstorage",
        title = "55. Web Storage API",
        category = "HTML",
        description = "Το Web Storage αποθηκεύει δεδομένα μέσα στον browser, χωρίς διακομιστή. Το localStorage κρατά τα δεδομένα και μετά το κλείσιμο της καρτέλας, ενώ το sessionStorage μόνο όσο είναι ανοιχτή. Χρησιμοποιείς setItem για να γράψεις και getItem για να διαβάσεις.\n\n" +
            "Οι τιμές αποθηκεύονται πάντα ως κείμενο. Στην προεπισκόπηση η αποθήκευση μπορεί να είναι απενεργοποιημένη, γι' αυτό ο κώδικας έχει try/catch και δείχνει μήνυμα.",
        codeExample = """
            <p id="out"></p>
            <script>
              var out = document.getElementById("out");
              try {
                var visits = Number(localStorage.getItem("visits")) || 0;
                visits = visits + 1;
                localStorage.setItem("visits", visits);
                out.textContent = "Visits: " + visits;
              } catch (e) {
                out.textContent = "Storage is not available here: " + e.name;
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο αποθηκεύει δεδομένα και μετά το κλείσιμο της καρτέλας;",
            options = listOf("sessionStorage", "Και τα δύο εξίσου", "Κανένα από τα δύο", "localStorage"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_webworkers",
        title = "56. Web Workers API",
        category = "HTML",
        description = "Ένας web worker τρέχει κώδικα JavaScript στο παρασκήνιο, σε ξεχωριστό νήμα, ώστε η σελίδα να μη «παγώνει» σε βαριούς υπολογισμούς. Τον φτιάχνεις με new Worker και επικοινωνείς μαζί του με postMessage και onmessage.\n\n" +
            "Εδώ ο worker φτιάχνεται από κείμενο με Blob, ώστε να μη χρειάζεται ξεχωριστό αρχείο. Αν το περιβάλλον δεν τον επιτρέπει, θα δεις ένα μήνυμα.",
        codeExample = """
            <p id="out">Calculating...</p>
            <script>
              var out = document.getElementById("out");
              try {
                var code = "onmessage = function (e) { var s = 0; for (var i = 0; i <= e.data; i++) s += i; postMessage(s); };";
                var worker = new Worker(URL.createObjectURL(new Blob([code])));
                worker.onmessage = function (e) { out.textContent = "Sum = " + e.data; worker.terminate(); };
                worker.postMessage(1000000);
              } catch (err) {
                out.textContent = "Workers are not available here: " + err.name;
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Πού τρέχει ο κώδικας ενός web worker;",
            options = listOf("Στο παρασκήνιο, σε ξεχωριστό νήμα", "Μέσα στο <head>", "Στον διακομιστή", "Μέσα σε ένα iframe"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_sse",
        title = "57. Server-Sent Events API",
        category = "HTML",
        description = "Τα Server-Sent Events (SSE) επιτρέπουν σε έναν διακομιστή να στέλνει συνεχώς νέα δεδομένα στη σελίδα, π.χ. ειδήσεις ή τιμές μετοχών. Ανοίγεις τη σύνδεση με new EventSource(διεύθυνση) και διαβάζεις τα μηνύματα στο onmessage.\n\n" +
            "Η κατεύθυνση είναι μόνο από τον διακομιστή προς τον browser. Επειδή εδώ δεν υπάρχει διακομιστής, το παράδειγμα δείχνει ένα μήνυμα σφάλματος, αλλά ο κώδικας είναι σωστός.",
        codeExample = """
            <p id="out">Waiting for server events...</p>
            <script>
              var out = document.getElementById("out");
              try {
                var source = new EventSource("https://example.com/events");
                source.onmessage = function (e) { out.textContent = e.data; };
                source.onerror = function () {
                  out.textContent = "No server here, but the code is correct!";
                  source.close();
                };
              } catch (err) {
                out.textContent = "EventSource is not available: " + err.name;
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Προς ποια κατεύθυνση στέλνονται δεδομένα στα SSE;",
            options = listOf("Από τον browser προς τον διακομιστή", "Από τον διακομιστή προς τον browser", "Και προς τις δύο κατευθύνσεις", "Μεταξύ δύο browsers"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_accessibility",
        title = "58. Προσβασιμότητα",
        category = "HTML",
        description = "Η προσβασιμότητα σημαίνει ότι η σελίδα μπορεί να χρησιμοποιηθεί από όλους, και από ανθρώπους που βλέπουν ή ακούν δύσκολα ή δεν χρησιμοποιούν ποντίκι. Βάζε alt στις εικόνες, label στα πεδία, σημασιολογικά tags και αρκετή αντίθεση χρωμάτων.\n\n" +
            "Όταν ένα κουμπί έχει μόνο εικονίδιο, πρόσθεσε aria-label ώστε να το διαβάζει ο αναγνώστης οθόνης. Φρόντισε να δουλεύουν όλα και με το πληκτρολόγιο.",
        codeExample = """
            <button aria-label="Close menu" style="font-size: 20px;">✕</button>
            <br><br>
            <label for="email">Email:</label>
            <input id="email" type="email">
            <br><br>
            <img src="chart.png" alt="Sales grew 20% in 2026">
        """.trimIndent(),
        quiz = Quiz(
            question = "Τι βοηθά έναν αναγνώστη οθόνης να περιγράψει μια εικόνα;",
            options = listOf("Η ιδιότητα width", "Το χρώμα φόντου", "Η ιδιότητα alt", "Το όνομα του αρχείου μόνο"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_project",
        title = "59. Μικρό project: η σελίδα σου",
        category = "HTML",
        description = "Ώρα να συνδυάσεις όσα έμαθες σε μια ολοκληρωμένη σελίδα: δομή με header, main και footer, επικεφαλίδες, κείμενο, λίστα, σύνδεσμο, εικόνα και λίγο CSS.\n\n" +
            "Αντίγραψε τον κώδικα, άλλαξε τα κείμενα και τα χρώματα και φτιάξε τη δική σου προσωπική σελίδα. Αποθήκευσέ την ως index.html και άνοιξέ την στον browser.",
        codeExample = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
              <meta charset="UTF-8">
              <title>About me</title>
              <style>
                body { font-family: sans-serif; margin: 0; }
                header, footer { background: #3f51b5; color: white; padding: 12px; text-align: center; }
                main { padding: 12px; }
              </style>
            </head>
            <body>
              <header><h1>Hi, I am Alex</h1></header>
              <main>
                <h2>My hobbies</h2>
                <ul>
                  <li>Coding</li>
                  <li>Music</li>
                </ul>
                <img src="me.jpg" alt="A photo of me" width="120">
                <p>Read more on <a href="https://example.com">my blog</a>.</p>
              </main>
              <footer>&copy; 2026 Alex</footer>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Ποιο tag χρησιμοποιείς για το κύριο περιεχόμενο της σελίδας;",
            options = listOf("<head>", "<title>", "<meta>", "<main>"),
            correctOptionIndex = 3,
        ),
    ),
)
