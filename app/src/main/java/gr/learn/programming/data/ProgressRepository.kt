package gr.learn.programming.data

import android.content.Context
import androidx.core.content.edit
import gr.learn.programming.model.UserProgress
import gr.learn.programming.i18n.AppLanguage

/** Τοπική (offline) αποθήκευση της προόδου και ρυθμίσεων με SharedPreferences. */
class ProgressRepository(context: Context) {

    private val prefs = context.getSharedPreferences("progress", Context.MODE_PRIVATE)

    fun load(): UserProgress = UserProgress(
        completedLessonIds = prefs.getStringSet(KEY_COMPLETED, emptySet())?.toSet() ?: emptySet(),
        totalScore = prefs.getInt(KEY_SCORE, 0),
    )

    fun save(progress: UserProgress) {
        prefs.edit {
            putStringSet(KEY_COMPLETED, progress.completedLessonIds.toSet())
            putInt(KEY_SCORE, progress.totalScore)
        }
    }

    fun isSoundEnabled(): Boolean = prefs.getBoolean(KEY_SOUND_ENABLED, true)

    fun setSoundEnabled(enabled: Boolean) {
        prefs.edit { putBoolean(KEY_SOUND_ENABLED, enabled) }
    }

    fun getAppLanguage(): AppLanguage =
        AppLanguage.fromCode(prefs.getString(KEY_APP_LANGUAGE, null))

    fun setAppLanguage(language: AppLanguage) {
        prefs.edit { putString(KEY_APP_LANGUAGE, language.code) }
    }

    /** Σβήνει την πρόοδο, αλλά κρατά τη γλώσσα της εφαρμογής που διάλεξε ο χρήστης. */
    fun clear() {
        val language = getAppLanguage()
        prefs.edit {
            clear()
            putString(KEY_APP_LANGUAGE, language.code)
        }
    }

    private companion object {
        const val KEY_COMPLETED = "completed_lesson_ids"
        const val KEY_SCORE = "total_score"
        const val KEY_SOUND_ENABLED = "sound_enabled"
        const val KEY_APP_LANGUAGE = "app_language"
    }
}
