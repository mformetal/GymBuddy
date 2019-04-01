package mformetal.gymbuddy.home

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import com.soywiz.klock.months
import mformetal.gymbuddy.extensions.formatAsMonthYear
import mformetal.gymbuddy.kedux.Reducer

class HomeReducer : Reducer<HomeActions, HomeState> {
    override fun reduce(action: HomeActions, state: HomeState): HomeState {
        return when (action) {
            HomeActions.NextClicked -> {
                val nextMonth = state.currentMonthDate.plus(1.months)
                val formattedDate = nextMonth.formatAsMonthYear()
                state.copy(currentMonthYearText = formattedDate, currentMonthDate = nextMonth)
            }
            HomeActions.PrevClicked -> {
                val nextMonth = state.currentMonthDate.minus(1.months)
                val formattedDate = nextMonth.formatAsMonthYear()
                state.copy(currentMonthYearText = formattedDate, currentMonthDate = nextMonth)
            }
            HomeActions.JumpToToday -> {
                val today = DateTime.now()
                val formattedDate = today.formatAsMonthYear()
                state.copy(currentMonthYearText = formattedDate, currentMonthDate = today)
            }
        }
    }
}