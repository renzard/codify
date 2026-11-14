package gr.learn.programming.i18n

/**
 * Οι γλώσσες της ίδιας της εφαρμογής (μενού, κουμπιά, μηνύματα).
 * Δεν έχει σχέση με τις γλώσσες προγραμματισμού (Python κ.λπ.).
 *
 * Για να προσθέσεις νέα γλώσσα:
 *  1. Πρόσθεσε μια τιμή εδώ, π.χ. ENGLISH("en", "English")
 *  2. Φτιάξε ένα νέο αρχείο, π.χ. EnglishStrings.kt, που υλοποιεί το [Strings]
 *  3. Πρόσθεσε τη γραμμή της στο `when` της [strings] (Strings.kt)
 */
enum class AppLanguage(val code: String, val nativeName: String) {
    ENGLISH(code = "en", nativeName = "English"),
    GREEK(code = "el", nativeName = "Ελληνικά"),
    ;

    companion object {
        /** Η γλώσσα που βλέπει όποιος ανοίγει την εφαρμογή για πρώτη φορά. */
        val DEFAULT = ENGLISH

        fun fromCode(code: String?): AppLanguage =
            entries.firstOrNull { it.code == code } ?: DEFAULT
    }
}
