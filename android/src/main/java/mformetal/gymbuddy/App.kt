package mformetal.gymbuddy

import android.app.Application
import android.system.Os.bind
import com.squareup.leakcanary.LeakCanary
import mformetal.gymbuddy.di.Deps
import mformetal.gymbuddy.extensions.takeIfFalse

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initLeakCanary()
    }

    private fun initLeakCanary() {
        LeakCanary.isInAnalyzerProcess(this).takeIfFalse {
            LeakCanary.install(this)
        }
    }
}