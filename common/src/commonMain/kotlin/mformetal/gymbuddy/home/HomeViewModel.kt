package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.Dispatcher
import mformetal.gymbuddy.kedux.SimpleStore
import mformetal.gymbuddy.kedux.Store

class HomeViewModel(private val dispatcher: Dispatcher<HomeActions, HomeActions>,
                    private val store: SimpleStore<HomeState>) {

    val currentMonthYearString : String = {
        "FAKE BULLSHIT"
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