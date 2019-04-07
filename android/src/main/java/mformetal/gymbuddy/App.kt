package mformetal.gymbuddy

import android.app.Application
import android.system.Os.bind
import com.squareup.leakcanary.LeakCanary
import mformetal.gymbuddy.di.Deps
import mformetal.gymbuddy.extensions.takeIfFalse
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(Deps.rootModule)
    }

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