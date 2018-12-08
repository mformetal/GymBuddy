package home

import kedux.Store

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
            viewController.setMessage(state.text)
        }
    }
}