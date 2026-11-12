package gr.learn.programming

import gr.learn.programming.util.SoundManager
import android.app.Application
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SoundManager.init(this)
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
    }
}
