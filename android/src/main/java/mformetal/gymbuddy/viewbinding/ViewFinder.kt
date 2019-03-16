package mformetal.gymbuddy.viewbinding

import android.view.View
import androidx.annotation.IdRes
import kotlin.reflect.KClass

interface ViewFinder {

    fun <T : View> find(@IdRes id: Int, viewClass: KClass<T>): T
}