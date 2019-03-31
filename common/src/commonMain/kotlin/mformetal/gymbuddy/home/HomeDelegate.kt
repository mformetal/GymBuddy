package mformetal.gymbuddy.home

import mformetal.kedux.ComponentDelegate
import mformetal.kedux.Store

class HomeDelegate(private val viewModel: HomeViewModel,
                   private val controller: Store.Listener<HomeState>) : ComponentDelegate {

    override fun onViewLoaded() {
        viewModel.listen(controller)
    }

    override fun onViewDestroyed() {
        viewModel.ignore(controller)
    }
}