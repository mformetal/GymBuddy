package home

import android.os.Bundle
import androidx.core.app.ComponentActivity
import kedux.Dispatcher
import mformetal.gymbuddy.R

class HomeActivity : ComponentActivity() {

    private val delegate : HomeDelegate by lazy {
        val store = HomeStore()
        val reducer = HomeReducer()
        val dispatcher = Dispatcher.forStore(store, reducer)
        val viewModel = HomeViewModel(dispatcher, store)
        HomeDelegate(viewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        delegate.bind()
        delegate.onViewLoaded()
    }

    override fun onDestroy() {
        super.onDestroy()

        delegate.onViewDestroyed()
    }
}