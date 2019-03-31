package mformetal.gymbuddy.base.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import mformetal.gymbuddy.kedux.ComponentDelegate
import mformetal.gymbuddy.viewbinding.AndroidViewFinder
import mformetal.gymbuddy.viewbinding.ViewController

abstract class DelegateFragment<D : ComponentDelegate, C: ViewController> : Fragment() {

    private lateinit var delegate: D
    private lateinit var controller: C

    abstract fun controller() : C

    abstract fun delegate() : D

    @LayoutRes
    abstract fun layoutId() : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layoutId(), container, false).also {
                controller.bind(AndroidViewFinder(it))

                delegate.onViewLoaded()
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