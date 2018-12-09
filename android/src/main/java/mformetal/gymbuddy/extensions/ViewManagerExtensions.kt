package mformetal.gymbuddy.extensions

import android.view.ViewManager
import mformetal.gymbuddy.widget.CollapsibleCalendarView
import org.jetbrains.anko.custom.ankoView

fun ViewManager.collapsibleCalendar(init: CollapsibleCalendarView.() -> Unit) : CollapsibleCalendarView {
    return ankoView({ CollapsibleCalendarView(it) }, theme = 0, init = init)
}