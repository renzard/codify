package gr.learn.programming.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import gr.learn.programming.data.ProgressRepository
import gr.learn.programming.model.UserProgress
import gr.learn.programming.util.SoundManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import gr.learn.programming.i18n.AppLanguage

class ProgressViewModel(app: Application) : AndroidViewModel(app) {

    private val repository = ProgressRepository(app)
    private val _progress = MutableStateFlow(repository.load())
    val progress: StateFlow<UserProgress> = _progress.asStateFlow()

    private val _soundEnabled = MutableStateFlow(repository.isSoundEnabled())
    val soundEnabled: StateFlow<Boolean> = _soundEnabled.asStateFlow()

    private val _appLanguage = MutableStateFlow(repository.getAppLanguage())
    val appLanguage: StateFlow<AppLanguage> = _appLanguage.asStateFlow()

    init {
        SoundManager.isEnabled = _soundEnabled.value
    }

    fun setSoundEnabled(enabled: Boolean) {
        _soundEnabled.value = enabled
        SoundManager.isEnabled = enabled
        repository.setSoundEnabled(enabled)
    }

    fun setAppLanguage(language: AppLanguage) {
        _appLanguage.value = language
        repository.setAppLanguage(language)
    }

    /** Οι πόντοι δίνονται μόνο την πρώτη φορά που ολοκληρώνεται ένα μάθημα. */
    fun completeLesson(lessonId: String, points: Int = 10) {
        val current = _progress.value
        if (current.isCompleted(lessonId)) return
        val next = current.copy(
            completedLessonIds = current.completedLessonIds + lessonId,
            totalScore = current.totalScore + points,
        )
        _progress.value = next
        repository.save(next)
    }

    fun reset() {
        _progress.value = UserProgress()
        repository.clear()
        setSoundEnabled(enabled = true)
    }
}
