package mformetal.gymbuddy.extensions

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes

fun Context.getResourceIdAttribute(@AttrRes attribute: Int) : Int {
    return TypedValue().also {
        theme.resolveAttribute(attribute, it, true)
    }.resourceId
}