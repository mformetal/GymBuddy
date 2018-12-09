package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.Dispatcher
import mformetal.gymbuddy.kedux.SimpleStore
import mformetal.gymbuddy.kedux.Store
import mformetal.gymbuddy.time.dateAtToday
import mformetal.gymbuddy.time.formatWith

class HomeViewModel(private val dispatcher: Dispatcher<HomeActions, HomeActions>,
                    private val store: SimpleStore<HomeState>) {

    val currentMonthYearString : String = {
        val today = dateAtToday()
        today.formatWith("MMMM yyyy")
    }()

    fun listen(listener: Store.Listener<HomeState>) {
        store.addListener(listener)
    }

    fun ignore(listener: Store.Listener<HomeState>) {
        store.removeListener(listener)
    }

    fun onDaySelected(day: Int, month: Int, year: Int) {

    }

    fun onMonthChanged(month: Int, year: Int) {

    }
}