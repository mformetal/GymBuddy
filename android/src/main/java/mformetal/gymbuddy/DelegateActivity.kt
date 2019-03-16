package mformetal.gymbuddy

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.core.app.ComponentActivity
import mformetal.gymbuddy.home.ComponentDelegate

abstract class DelegateActivity<D : ComponentDelegate> : ComponentActivity() {

    private lateinit var delegate: D

    abstract fun provide() : D

    @LayoutRes
    abstract fun layoutId() : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        delegate = provide().also {
            setContentView(layoutId())

            it.onViewLoaded()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        delegate.onViewDestroyed()
    }
}