package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.Store

class HomeDelegate(private val viewModel: HomeViewModel,
                   private val viewController: HomeViewController) {

    fun onViewLoaded() {
        viewModel.listen(listener)
    }

    fun onViewDestroyed() {
        viewModel.ignore(listener)
    }

    private val listener : Store.Listener<HomeState> = object : Store.Listener<HomeState> {
        override fun onNewState(state: HomeState) {
            viewController.render(state)
        }
    }
}