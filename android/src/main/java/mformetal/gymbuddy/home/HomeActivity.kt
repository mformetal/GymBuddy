package mformetal.gymbuddy.home

import android.os.Bundle
import androidx.core.app.ComponentActivity
import mformetal.gymbuddy.DelegateActivity
import mformetal.gymbuddy.R
import mformetal.gymbuddy.kedux.Dispatcher
import org.jetbrains.anko.setContentView

class HomeActivity : DelegateActivity<HomeDelegate>() {

    override fun layoutId(): Int = R.layout.home

    override fun provide(): HomeDelegate {
        val store = HomeStore()
        val reducer = HomeReducer()
        val dispatcher = Dispatcher.forStore(store, reducer)
        val viewModel = HomeViewModel(dispatcher, store)
        val controller = HomeViewController(viewModel).also {
            it.setContentView(this)
        }
        return HomeDelegate(viewModel, controller)
    }
}