package mformetal.gymbuddy.home

import mformetal.gymbuddy.kedux.presentation.ComponentController
import mformetal.gymbuddy.kedux.presentation.ComponentDelegate
import mformetal.gymbuddy.kedux.state.AppState

class HomeDelegate(viewModel: HomeViewModel,
                   componentController: ComponentController<AppState>) : ComponentDelegate<AppState>(viewModel, componentController)