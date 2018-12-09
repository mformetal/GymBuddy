package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.Reducer
import mformetal.gymbuddy.time.*

class HomeReducer : Reducer<HomeActions, HomeState> {
    override fun reduce(action: HomeActions, state: HomeState): HomeState {
        return when (action) {
            HomeActions.NextClicked -> {
                val nextMonth = state.currentMonthDate.addMonths(1)
                val formattedDate = nextMonth.formatAsMonthYear()
                state.copy(currentMonthYearText = formattedDate, currentMonthDate = nextMonth)
            }
            HomeActions.PrevClicked -> {
                val nextMonth = state.currentMonthDate.minusMonths(1)
                val formattedDate = nextMonth.formatAsMonthYear()
                state.copy(currentMonthYearText = formattedDate, currentMonthDate = nextMonth)
            }
            HomeActions.JumpToToday -> {
                val today = dateAtToday()
                val formattedDate = today.formatAsMonthYear()
                state.copy(currentMonthYearText = formattedDate, currentMonthDate = today)
            }
        }
    }
}