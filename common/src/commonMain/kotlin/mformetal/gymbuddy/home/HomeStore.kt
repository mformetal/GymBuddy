package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.SimpleStore
import mformetal.gymbuddy.time.dateAtToday
import mformetal.gymbuddy.time.formatWith

fun createInitialState() : HomeState {
    val today = dateAtToday()
    val formattedDate = today.formatWith("MMMM yyyy")
    return HomeState(currentMonthDate = today, currentMonthYearText = formattedDate)
}

class HomeStore : SimpleStore<HomeState>(initialState = createInitialState())