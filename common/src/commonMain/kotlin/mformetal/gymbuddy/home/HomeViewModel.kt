package mformetal.gymbuddy.home

import com.soywiz.klock.DateTime
import kotlinx.coroutines.CoroutineDispatcher
import mformetal.gymbuddy.expectations.DispatcherHolder
import mformetal.gymbuddy.kedux.arch.Store
import mformetal.gymbuddy.kedux.arch.ViewModel
import mformetal.gymbuddy.kedux.state.AppState

class HomeViewModel(store: Store<AppState>,
                    dispatcherHolder: DispatcherHolder) : ViewModel<AppState>(store, dispatcherHolder.ui, dispatcherHolder.io) {

    fun showNextMonth() {

    }

    fun showPreviousMontu() {

    }
}