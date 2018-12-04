package home

import android.view.Window
import mformetal.gymbuddy.lib.R

actual class HomeDelegateViewFinder(private val window: Window) {

    actual fun findContent(delegate: HomeDelegate) {
        delegate.text = window.findViewById(R.id.hello)
        delegate.button = window.findViewById(R.id.counter)
    }
}