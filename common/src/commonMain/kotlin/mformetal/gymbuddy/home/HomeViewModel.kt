package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.Dispatcher
import mformetal.gymbuddy.kedux.SimpleStore
import mformetal.gymbuddy.kedux.Store
import mformetal.gymbuddy.time.dateAtToday
import mformetal.gymbuddy.time.formatWith

class HomeViewModel(private val dispatcher: Dispatcher<HomeActions, HomeActions>,
                    private val store: SimpleStore<HomeState>) {

    fun listen(listener: Store.Listener<HomeState>) {
        store.addListener(listener)
    }

    fun ignore(listener: Store.Listener<HomeState>) {
        store.removeListener(listener)
    }

    fun goToNextMonth() {
        dispatcher.dispatch(HomeActions.NextClicked)
    }

    fun goToPreviousMonth() {
        dispatcher.dispatch(HomeActions.PrevClicked)
    }

    fun jumpToToday() {
        dispatcher.dispatch(HomeActions.JumpToToday)
    }
}