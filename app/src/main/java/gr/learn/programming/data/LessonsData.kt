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
)
