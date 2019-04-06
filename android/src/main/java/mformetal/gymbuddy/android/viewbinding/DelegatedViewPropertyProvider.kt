package mformetal.gymbuddy.android.viewbinding

import android.view.View
import androidx.annotation.IdRes
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class DelegatedViewPropertyProvider {

    protected var viewFinder: ViewFinder? = null

    fun bind(viewFinder: ViewFinder) {
        this.viewFinder = viewFinder
    }

    fun <T : View> find(id: Int, viewClass: KClass<T>): ReadOnlyProperty<Any, T> =
            ViewInjectionProperty(id, viewClass)

    protected inner class ViewInjectionProperty<T : View>(
            @IdRes private val id: Int,
            private val viewClass: KClass<T>
    ) :
            ReadOnlyProperty<Any, T> {

        override fun getValue(thisRef: Any, property: KProperty<*>): T =
                this@DelegatedViewPropertyProvider.viewFinder?.find(id, viewClass)
                ?: throw UninitializedPropertyAccessException("Make sure to call bind with a ViewFinder before accessing")
    }
}

inline fun <reified T : View> DelegatedViewPropertyProvider.find(id: Int): ReadOnlyProperty<Any, T> = find(id, T::class)