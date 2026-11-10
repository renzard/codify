package gr.learn.programming.i18n

import gr.learn.programming.data.languagesEl
import gr.learn.programming.data.lessonsEl
import gr.learn.programming.model.Language
import gr.learn.programming.model.Lesson

object GreekStrings : Strings {
    override val languageCode = "el"
    override val lessonList: List<Lesson> = lessonsEl
    override val programmingLanguages: List<Language> = languagesEl

    // Κοινά
    override val back = "Πίσω"
    override val cancel = "Άκυρο"
    override val resetAction = "Μηδενισμός"
    override val menu = "Μενού"
    override val settings = "Ρυθμίσεις"

    // Επιλογή γλώσσας προγραμματισμού
    override val chooseProgrammingLanguageTitle = "Επιλογή Γλώσσας"
    override val whichLanguageQuestion = "Ποια γλώσσα προγραμματισμού θέλεις να μάθεις;"
    override val pickLanguageToStart = "Επίλεξε μια γλώσσα για να ξεκινήσεις τα διαδραστικά μαθήματα."
    override fun lessonCount(count: Int) = "$count μαθήματα"
    override val select = "Επιλογή"

    // Λίστα μαθημάτων
    override val lessons = "Μαθήματα"
    override val resetProgress = "Μηδενισμός προόδου"
    override val resetProgressConfirmShort = "Θα διαγραφούν όλα τα ολοκληρωμένα μαθήματα και οι πόντοι σου. Να συνεχίσω;"
    override val yourProgress = "Η πρόοδός σου"
    override fun lessonsCompleted(done: Int, total: Int) = "$done από $total μαθήματα ολοκληρώθηκαν"
    override fun pointsLabel(score: Int) = "Πόντοι: $score"
    override val completed = "Ολοκληρώθηκε"
    override val locked = "Κλειδωμένο"
    override fun completePrevious(previousTitle: String) = "Ολοκλήρωσε πρώτα το μάθημα «$previousTitle»!"

    // Μάθημα
    override val startQuiz = "Ξεκίνα το Quiz"
    override val codeExample = "Παράδειγμα κώδικα"
    override val running = "Εκτελείται…"
    override val run = "Εκτέλεση"
    override val restore = "Επαναφορά"
    override val unknownError = "Άγνωστο σφάλμα"

    // Κουτί κώδικα
    override val codeEditorHeader = "Python · μπορείς να αλλάξεις τον κώδικα"
    override val output = "Έξοδος"
    override val noOutput = "(ο κώδικας δεν τύπωσε τίποτα)"

    // Quiz
    override val correctAnswer = "Σωστή απάντηση!"
    override val wrongAnswer = "Λάθος απάντηση. Δοκίμασε ξανά!"
    override val tryAgain = "Δοκίμασε ξανά"
    override val finishLesson = "Ολοκλήρωση μαθήματος"
    override val nextStep = "Συνέχεια"

    // Συμπλήρωση κενών
    override val fillBlankTitle = "Συμπλήρωσε τα κενά"
    override val fillBlankInstruction = "Συμπλήρωσε τα κενά ώστε ο κώδικας να δουλεύει σωστά."
    override val checkAnswers = "Έλεγχος"
    override val fillBlankCorrect = "Μπράβο! Όλα σωστά!"
    override val fillBlankWrong = "Κάποια κενά είναι λάθος. Δοκίμασε ξανά!"

    // Μηνύματα (Toast)
    override val lessonLocked = "Το μάθημα είναι κλειδωμένο!"
    override fun lessonCompletedAgain(title: String) = "Ολοκλήρωσες ξανά το μάθημα «$title»!"
    override fun lessonCompletedFirst(title: String) = "Μπράβο! (+10 πόντοι) Ολοκλήρωσες το μάθημα «$title»."

    // Ρυθμίσεις
    override val appLanguageSection = "Γλώσσα εφαρμογής"
    override val appLanguageDescription = "Επίλεξε τη γλώσσα των μενού και των μηνυμάτων της εφαρμογής."
    override val soundSection = "Ήχος & Εφέ"
    override val appSounds = "Ήχοι εφαρμογής"
    override val appSoundsDescription = "Ηχητικά εφέ για σωστές και λάθος απαντήσεις στα quiz"
    override val progressSection = "Πρόοδος & Δεδομένα"
    override val resetProgressTitle = "Μηδενισμός Προόδου"
    override fun progressSummary(lessons: Int, points: Int) = "$lessons ολοκληρωμένα μαθήματα · $points πόντοι"
    override val deleteProgress = "Διαγραφή προόδου"
    override val resetProgressConfirmLong = "Θα διαγραφούν όλα τα ολοκληρωμένα μαθήματα και οι πόντοι σου. Είσαι σίγουρος/η;"
    override val aboutSection = "Σχετικά"
    override val versionInfo = "Έκδοση 1.0.0 · Python 3.11 (Offline Runner)"
}
