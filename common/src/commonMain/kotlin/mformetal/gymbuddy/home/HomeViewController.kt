package mformetal.gymbuddy.home

import expectations.TextWidget
import expectations.Widget
import expectations.body

@Suppress("MemberVisibilityCanBePrivate")
abstract class HomeViewController {

    abstract fun createView(any: Any) : Widget
}