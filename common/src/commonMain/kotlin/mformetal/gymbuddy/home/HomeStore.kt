package mformetal.gymbuddy.home

import com.soywiz.klock.DateTime
import mformetal.gymbuddy.extensions.formatAsMonthYear
import mformetal.gymbuddy.kedux.SimpleStore

fun createInitialState() : HomeState {
    val today = DateTime.now()
    val formattedDate = today.formatAsMonthYear()
    return HomeState(currentMonthDate = today, currentMonthYearText = formattedDate)
}

class HomeStore : SimpleStore<HomeState>(initialState = createInitialState())