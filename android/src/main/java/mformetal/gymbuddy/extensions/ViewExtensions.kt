package mformetal.gymbuddy.extensions

import android.view.View

fun View.generateId()  {
    id = View.generateViewId()
}