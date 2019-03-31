package mformetal.gymbuddy.home

import mformetal.kedux.Dispatcher
import mformetal.kedux.SimpleStore
import mformetal.kedux.Store

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