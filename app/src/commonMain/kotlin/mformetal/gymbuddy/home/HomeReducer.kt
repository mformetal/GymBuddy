package mformetal.gymbuddy.home

import kedux.Reducer

class HomeReducer : Reducer<HomeActions, HomeState> {
    override fun reduce(action: HomeActions, state: HomeState): HomeState {
        return when (action) {
            HomeActions.HelloClicked -> {
                state.copy(
                        counter = state.counter.inc()
                )
            }
        }
    }
}