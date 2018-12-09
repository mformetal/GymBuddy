package mformetal.gymbuddy.home

import android.os.Bundle
import androidx.core.app.ComponentActivity
import mformetal.gymbuddy.kedux.Dispatcher
import org.jetbrains.anko.setContentView

class HomeActivity : ComponentActivity() {

    private lateinit var delegate: HomeDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val store = HomeStore()
        val reducer = HomeReducer()
        val dispatcher = Dispatcher.forStore(store, reducer)
        val viewModel = HomeViewModel(dispatcher, store)
        val controller = HomeViewController(viewModel).also {
            it.setContentView(this)
        }
        delegate = HomeDelegate(viewModel, controller)

        delegate.onViewLoaded()
    }

    override fun onDestroy() {
        super.onDestroy()

        delegate.onViewDestroyed()
    }
}