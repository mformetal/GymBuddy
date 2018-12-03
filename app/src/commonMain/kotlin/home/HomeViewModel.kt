package home

import kedux.Dispatcher
import kedux.SimpleStore
import kedux.Store

class HomeViewModel(private val dispatcher: Dispatcher<HomeActions, HomeActions>,
                    private val store: SimpleStore<HomeState>) {

    fun onHelloClicked() {
        dispatcher.dispatch(HomeActions.HelloClicked)
    }

    fun observe(listener: Store.Listener<HomeState>) {
        store.addListener(listener)
    }

    fun cease(listener: Store.Listener<HomeState>) {
        store.removeListener(listener)
    }
}