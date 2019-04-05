package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.presentation.ComponentController
import mformetal.gymbuddy.kedux.presentation.ComponentDelegate
import mformetal.gymbuddy.kedux.state.AppState

class HomeDelegate(private val viewModel: HomeViewModel,
                   override val componentController: ComponentController<AppState>) : ComponentDelegate<AppState> {

    override fun onViewCreated() {

    }

    override fun onViewDestroyed() {

    }

    override fun listen(onStateChanged: (AppState) -> Unit) = viewModel.subscribe(onStateChanged)
}