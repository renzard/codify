package gr.learn.programming.util

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.annotation.RawRes
import gr.learn.programming.R
import java.util.concurrent.ConcurrentHashMap

/**
 * Διαχειριστής ηχητικών εφέ.
 *
 * - click  -> sound_click.mp3 (κάθε πάτημα κουμπιού)
 * - true   -> sound_true.mp3  (σωστή απάντηση)
 * - false  -> sound_false.mp3 (λάθος απάντηση)
 *
 * Καλείται SoundManager.init(context) μία φορά στο App.onCreate().
 */
object SoundManager {
    private var appContext: Context? = null
    private var clickPool: SoundPool? = null
    private var clickId = 0
    private val loaded = ConcurrentHashMap.newKeySet<Int>()
    private var answerPlayer: MediaPlayer? = null

    var isEnabled: Boolean = true

    fun init(context: Context) {
        if (appContext != null) return
        val app = context.applicationContext
        appContext = app

        val attrs = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        val pool = SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(attrs)
            .build()
        pool.setOnLoadCompleteListener { _, id, status ->
            if (status == 0) loaded.add(id)
        }
        clickId = pool.load(app, R.raw.sound_click, 1)
        clickPool = pool
    }

    /** Ήχος για κάθε click. */
    fun playClick() {
        if (!isEnabled) return
        val pool = clickPool ?: return
        if (clickId !in loaded) return
        try {
            pool.play(clickId, 1f, 1f, 1, 0, 1f)
        } catch (_: Exception) {
        }
    }

    /** Ήχος για σωστή απάντηση. */
    fun playCorrect() = playAnswer(R.raw.sound_true)

    /** Ήχος για λάθος απάντηση. */
    fun playIncorrect() = playAnswer(R.raw.sound_false)

    private fun playAnswer(@RawRes resId: Int) {
        if (!isEnabled) return
        val ctx = appContext ?: return
        try {
            // Σταματάμε τυχόν προηγούμενο ήχο απάντησης ώστε να μην επικαλύπτονται.
            answerPlayer?.let {
                try { it.stop() } catch (_: Exception) {}
                it.release()
            }
            answerPlayer = null

            val player = MediaPlayer.create(ctx, resId) ?: return
            player.setOnCompletionListener {
                it.release()
                if (answerPlayer === it) answerPlayer = null
            }
            answerPlayer = player
            player.start()
        } catch (_: Exception) {
        }
    }
}
