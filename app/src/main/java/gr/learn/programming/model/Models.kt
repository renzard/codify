package gr.learn.programming.model

data class Quiz(
    val question: String,
    val options: List<String>,
    val correctOptionIndex: Int,
)

/** Μια γλώσσα προγραμματισμού που μπορεί να διαλέξει ο χρήστης. */
data class Language(
    val id: String,
    /** Πρέπει να ταιριάζει ακριβώς με το [Lesson.category] των μαθημάτων της. */
    val name: String,
    val description: String,
    /** Μικρό σύμβολο που εμφανίζεται μέσα στον κύκλο της κάρτας, π.χ. «Py». */
    val badge: String,
<<<<<<< HEAD
    /** false = τα παραδείγματα δεν εκτελούνται μέσα στην εφαρμογή (π.χ. εντολές Linux). */
    val runnable: Boolean = true,
    /** true = το παράδειγμα εμφανίζεται ως ιστοσελίδα σε WebView (HTML). */
    val previewHtml: Boolean = false,
=======
>>>>>>> 631cd6e1e97d010cb81b07551d6836e85c298b6c
)

data class Lesson(
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val codeExample: String,
    val quiz: Quiz,
<<<<<<< HEAD
    /** Αναμενόμενη έξοδος για γλώσσες που δεν εκτελούνται στην εφαρμογή (runnable = false). */
    val sampleOutput: String? = null,
=======
>>>>>>> 631cd6e1e97d010cb81b07551d6836e85c298b6c
)

data class UserProgress(
    val completedLessonIds: Set<String> = emptySet(),
    val totalScore: Int = 0,
) {
    fun isCompleted(lessonId: String): Boolean = lessonId in completedLessonIds
}

/** Το σημάδι που δείχνει κενό μέσα στον κώδικα της άσκησης συμπλήρωσης. */
const val BLANK_MARKER = "___"

/**
 * Άσκηση «συμπλήρωσε τα κενά» που εμφανίζεται μετά το quiz.
 *
 * Ο [code] περιέχει ένα [BLANK_MARKER] για κάθε κενό. Το [answers] έχει μία λίστα
 * για κάθε κενό (με τη σειρά που εμφανίζονται), με όλες τις αποδεκτές απαντήσεις.
 */
data class FillBlank(
    val code: String,
    val answers: List<List<String>>,
)
