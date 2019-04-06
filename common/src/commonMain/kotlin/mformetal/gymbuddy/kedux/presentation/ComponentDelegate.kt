package mformetal.gymbuddy.kedux.presentation

import mformetal.gymbuddy.kedux.arch.ViewModel

abstract class ComponentDelegate<S : Any>(
        protected val viewModel: ViewModel<S>,
        protected val componentController: ComponentController<S>) {

    open fun onViewCreated(view: Any) {
        componentController.bind(view)
        viewModel.subscribe(componentController.render)
    }

    open fun onViewDestroyed() {
        viewModel.unsubscribe()
    }
}