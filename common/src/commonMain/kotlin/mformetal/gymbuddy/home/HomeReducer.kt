package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.Reducer

class HomeReducer : Reducer<HomeActions, HomeState> {
    override fun reduce(action: HomeActions, state: HomeState): HomeState {
        return when (action) {
            HomeActions.CounterClicked -> {
                val inc = state.counter.inc()
                state.copy(
                        counter = inc,
                        text = "Hello, $inc times!"
                )
            }
        }
    }
}