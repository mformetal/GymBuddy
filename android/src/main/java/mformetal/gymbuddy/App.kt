package mformetal.gymbuddy

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.squareup.leakcanary.LeakCanary
import mformetal.gymbuddy.extensions.takeIfFalse

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initLeakCanary()

        AndroidThreeTen.init(this)
    }

    private fun initLeakCanary() {
        LeakCanary.isInAnalyzerProcess(this).takeIfFalse {
            LeakCanary.install(this)
        }
    }
}