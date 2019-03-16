package mformetal.gymbuddy.viewbinding

import android.view.View
import kotlin.reflect.KClass

class AndroidViewFinder(private val root: View) : ViewFinder {

    override fun <T : View> find(id: Int, viewClass: KClass<T>): T = root.findViewById(id)
}