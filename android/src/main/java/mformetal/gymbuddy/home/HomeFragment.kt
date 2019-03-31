package mformetal.gymbuddy.home

import androidx.fragment.app.Fragment
import mformetal.gymbuddy.R
import mformetal.gymbuddy.base.android.DelegateFragment
import mformetal.gymbuddy.kedux.Dispatcher

class HomeFragment : DelegateFragment<HomeDelegate, HomeViewController>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    val viewModel by lazy {
        val store = HomeStore()
        val reducer = HomeReducer()
        val dispatcher = Dispatcher.forStore(store, reducer)
        HomeViewModel(dispatcher, store)
    }

    val controller by lazy {
        HomeViewController(viewModel)
    }

    override fun controller(): HomeViewController = controller

    override fun layoutId(): Int = R.layout.home

    override fun delegate(): HomeDelegate {
        val controller = HomeViewController(viewModel)
        return HomeDelegate(viewModel, controller)
    }
}