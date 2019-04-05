package mformetal.gymbuddy.home

import com.soywiz.klock.DateTime
import kotlinx.coroutines.CoroutineDispatcher
import mformetal.gymbuddy.kedux.arch.Store
import mformetal.gymbuddy.kedux.arch.ViewModel
import mformetal.gymbuddy.kedux.state.AppState

class HomeViewModel(store: Store<AppState>,
                    mainDispatcher: CoroutineDispatcher,
                    ioDispatcher: CoroutineDispatcher) : ViewModel<AppState>(store, mainDispatcher, ioDispatcher) {

    fun onFabClicked() {
        store.update(AppState("BUTTTTTT ${DateTime.now().seconds}"))
    }
}