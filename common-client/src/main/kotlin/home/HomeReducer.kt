package home

import kedux.Reducer

class HomeReducer : Reducer<HomeActions, HomeState> {
    override fun reduce(action: HomeActions, state: HomeState): HomeState {
        return state
    }
}