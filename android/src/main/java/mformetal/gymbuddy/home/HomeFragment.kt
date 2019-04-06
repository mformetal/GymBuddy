package mformetal.gymbuddy.home

import com.soywiz.klock.Month
import kotlinx.coroutines.Dispatchers
import mformetal.gymbuddy.R
import mformetal.gymbuddy.android.DelegateFragment
import mformetal.gymbuddy.kedux.arch.Store
import mformetal.gymbuddy.kedux.state.AppState
import mformetal.gymbuddy.kedux.state.CalendarState

class HomeFragment : DelegateFragment<AppState, HomeDelegate>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    val viewModel by lazy {
        HomeViewModel(Store(AppState(CalendarState(Month.get(1)))), Dispatchers.Main, Dispatchers.IO)
    }

    override fun layoutId(): Int = R.layout.home

    override fun delegate() = HomeDelegate(viewModel, HomeAndroidController(viewModel))
}