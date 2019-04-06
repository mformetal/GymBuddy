package mformetal.gymbuddy.utils

import android.view.View
import androidx.annotation.IdRes
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.mockk.mockk
import mformetal.gymbuddy.android.viewbinding.ViewFinder
import kotlin.reflect.KClass

class TestViewFinder : ViewFinder {

    private val mockFactories: MutableMap<KClass<out View>, () -> View> = mutableMapOf()
    private val viewMap: MutableMap<Int, View> = mutableMapOf()

    @Suppress("UNCHECKED_CAST")
    override fun <T : View> find(@IdRes id: Int, viewClass: KClass<T>): T =
            viewMap.getOrPut(id) { MockViewFactory.get(viewClass) } as T

    private object MockViewFactory {

        private val mocks = mapOf<KClass<out View>, View>(
                FloatingActionButton::class to mockk<FloatingActionButton>()
        )

        @Suppress("UNCHECKED_CAST")
        fun <T : View> get(viewClass: KClass<T>) : T = mocks.getValue(viewClass) as T
    }
}