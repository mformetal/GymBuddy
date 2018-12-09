package mformetal.gymbuddy

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initLeakCanary()
    }

    fun initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) return
        LeakCanary.install(this)
    }
}