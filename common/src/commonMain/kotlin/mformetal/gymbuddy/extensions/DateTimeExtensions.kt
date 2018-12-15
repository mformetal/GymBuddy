package mformetal.gymbuddy.extensions

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime

fun DateTime.formatAsMonthYear() : String {
    val formatter = DateFormat("MMMM yyyy")
    return format(formatter)
}