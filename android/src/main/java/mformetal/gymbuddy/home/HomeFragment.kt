package mformetal.gymbuddy.home

import kotlinx.coroutines.Dispatchers
import mformetal.gymbuddy.R
import mformetal.gymbuddy.base.android.DelegateFragment
import mformetal.gymbuddy.kedux.arch.Store
import mformetal.gymbuddy.kedux.presentation.ComponentController
import mformetal.gymbuddy.kedux.state.AppState

class HomeFragment : DelegateFragment<AppState, HomeDelegate, HomeAndroidController>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    val viewModel by lazy {
        HomeViewModel(Store(AppState()), Dispatchers.Main, Dispatchers.IO)
    }

    override fun layoutId(): Int = R.layout.home

    override fun controller(): HomeAndroidController = HomeAndroidController(viewModel)

    override fun delegate(controller: ComponentController<AppState>): HomeDelegate {
        return HomeDelegate(viewModel, controller)
    }
}