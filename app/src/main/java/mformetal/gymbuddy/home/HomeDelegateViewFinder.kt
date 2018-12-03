package mformetal.gymbuddy.home

import android.view.Window
import expectations.widget.Screen
import mformetal.gymbuddy.R

actual class HomeDelegateViewFinder(window: Window) {

    actual val screen: Screen = window

    actual fun findContent(delegate: HomeDelegate) {
        delegate.text = screen.findViewById(R.id.hello)
    }
}