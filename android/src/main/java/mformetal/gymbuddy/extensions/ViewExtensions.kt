package mformetal.gymbuddy.extensions

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.IdRes

val View.inflater
    get() = LayoutInflater.from(context)

inline fun <reified T : View> View.find(@IdRes id: Int) = findViewById<T>(id)