package mformetal.gymbuddy.home

import androidx.fragment.app.Fragment
import mformetal.gymbuddy.R
import mformetal.gymbuddy.base.android.DelegateFragment
import mformetal.gymbuddy.kedux.Dispatcher

class HomeFragment : DelegateFragment<HomeDelegate>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun layoutId(): Int = R.layout.home

    override fun provide(): HomeDelegate {
        val store = HomeStore()
        val reducer = HomeReducer()
        val dispatcher = Dispatcher.forStore(store, reducer)
        val viewModel = HomeViewModel(dispatcher, store)
        val controller = HomeViewController(viewModel)
        return HomeDelegate(viewModel, controller)
    }
}