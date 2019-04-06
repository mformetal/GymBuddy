package mformetal.gymbuddy.home

import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mformetal.gymbuddy.R
import mformetal.gymbuddy.kedux.state.AppState
import mformetal.gymbuddy.android.viewbinding.AndroidController
import mformetal.gymbuddy.android.viewbinding.find

class HomeAndroidController(private val viewModel: HomeViewModel) : AndroidController() {

    val fab by delegatedViewFinder.find<FloatingActionButton>(R.id.jump_to_today)

    override fun onViewsBound() {
        fab.setOnClickListener {
            viewModel.onFabClicked()
        }
    }

    override val render : (AppState) -> Unit = {
        Toast.makeText(fab.context, it.toPrint, Toast.LENGTH_LONG).show()
    }
}