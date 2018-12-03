package mformetal.gymbuddy.home

import expectations.widget.Screen

expect class HomeDelegateViewFinder {

    val screen : Screen

    fun findContent(delegate: HomeDelegate)
}