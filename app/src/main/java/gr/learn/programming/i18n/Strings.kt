package gr.learn.programming.i18n

import androidx.compose.runtime.staticCompositionLocalOf
import gr.learn.programming.model.Language
import gr.learn.programming.model.Lesson

/** Όλα τα κείμενα του περιβάλλοντος της εφαρμογής. Κάθε γλώσσα υλοποιεί αυτό το interface. */
interface Strings {
    /** Κωδικός γλώσσας (π.χ. "el", "en"). */
    val languageCode: String

    // Περιεχόμενο (μαθήματα και γλώσσες προγραμματισμού) σε αυτή τη γλώσσα
    val lessonList: List<Lesson>
    val programmingLanguages: List<Language>

    // Κοινά
    val back: String
    val cancel: String
    val resetAction: String
    val menu: String
    val settings: String

    // Επιλογή γλώσσας προγραμματισμού
    val chooseProgrammingLanguageTitle: String
    val whichLanguageQuestion: String
    val pickLanguageToStart: String
    fun lessonCount(count: Int): String
    val select: String

    // Λίστα μαθημάτων
    val lessons: String
    val resetProgress: String
    val resetProgressConfirmShort: String
    val yourProgress: String
    fun lessonsCompleted(done: Int, total: Int): String
    fun pointsLabel(score: Int): String
    val completed: String
    val locked: String
    fun completePrevious(previousTitle: String): String

    // Μάθημα
    val startQuiz: String
    val codeExample: String
    val running: String
    val run: String
    val restore: String
    val unknownError: String

    // Κουτί κώδικα
    val codeEditorHeader: String
    val output: String
    val noOutput: String
<<<<<<< HEAD
    val sampleOutputTitle: String
    val preview: String
    val previewTitle: String
    val notRunnableHint: String
    fun editorHeader(languageName: String): String
=======
>>>>>>> 631cd6e1e97d010cb81b07551d6836e85c298b6c

    // Quiz
    val correctAnswer: String
    val wrongAnswer: String
    val tryAgain: String
    val finishLesson: String
    val nextStep: String

    // Άσκηση συμπλήρωσης κενών
    val fillBlankTitle: String
    val fillBlankInstruction: String
    val checkAnswers: String
    val fillBlankCorrect: String
    val fillBlankWrong: String

    // Μηνύματα (Toast)
    val lessonLocked: String
    fun lessonCompletedAgain(title: String): String
    fun lessonCompletedFirst(title: String): String

    // Ρυθμίσεις
    val appLanguageSection: String
    val appLanguageDescription: String
    val soundSection: String
    val appSounds: String
    val appSoundsDescription: String
    val progressSection: String
    val resetProgressTitle: String
    fun progressSummary(lessons: Int, points: Int): String
    val deleteProgress: String
    val resetProgressConfirmLong: String
    val aboutSection: String
    val versionInfo: String
}

/** Επιστρέφει τα κείμενα της κάθε γλώσσας. Το `when` είναι εξαντλητικό: αν προσθέσεις γλώσσα και ξεχάσεις να τη βάλεις εδώ, δεν γίνεται compile. */
fun AppLanguage.strings(): Strings = when (this) {
    AppLanguage.GREEK -> GreekStrings
    AppLanguage.ENGLISH -> EnglishStrings
}

val LocalStrings = staticCompositionLocalOf<Strings> { EnglishStrings }
