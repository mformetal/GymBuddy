package mformetal.gymbuddy.base.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import mformetal.gymbuddy.kedux.ComponentDelegate

abstract class DelegateFragment<D : ComponentDelegate> : Fragment() {

    private lateinit var delegate: D

    abstract fun provide() : D

    @LayoutRes
    abstract fun layoutId() : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layoutId(), container, false).also {
                delegate.onViewLoaded()
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        delegate = provide()
    }

    override fun onDestroy() {
        super.onDestroy()

        delegate.onViewDestroyed()
    }
}