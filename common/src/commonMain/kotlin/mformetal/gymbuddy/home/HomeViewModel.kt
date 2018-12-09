package mformetal.gymbuddy.home

import kedux.Dispatcher
import kedux.SimpleStore
import kedux.Store

class HomeViewModel(private val dispatcher: Dispatcher<HomeActions, HomeActions>,
                    private val store: SimpleStore<HomeState>) {

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