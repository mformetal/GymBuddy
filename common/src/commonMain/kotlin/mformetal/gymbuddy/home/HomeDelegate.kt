package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.Store
import mformetal.gymbuddy.kedux.ViewController

class HomeDelegate(private val viewModel: HomeViewModel,
                   private val controller: ViewController<HomeState>) {

    fun onViewLoaded() {
        viewModel.listen(listener)
    }

    fun onViewDestroyed() {
        viewModel.ignore(listener)
    }

    private val listener : Store.Listener<HomeState> = object : Store.Listener<HomeState> {
        override fun onNewState(state: HomeState) {
            controller.render(state)
        }
    }
}