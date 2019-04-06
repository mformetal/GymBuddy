package mformetal.gymbuddy.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import mformetal.gymbuddy.kedux.presentation.ComponentDelegate
import mformetal.gymbuddy.android.viewbinding.AndroidViewFinder

abstract class DelegateFragment<S: Any, D : ComponentDelegate<S>> : Fragment() {

    private lateinit var delegate: D

    abstract fun delegate() : D

    @LayoutRes
    abstract fun layoutId() : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layoutId(), container, false).also { view ->
                with (delegate) {
                    onViewCreated(AndroidViewFinder(view))
                }
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        delegate = delegate()
    }

    override fun onDestroy() {
        super.onDestroy()

        delegate.onViewDestroyed()
    }
}