package mformetal.gymbuddy.home

import android.graphics.Color
import android.view.Gravity
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mformetal.gymbuddy.R
import mformetal.gymbuddy.kedux.Store
import mformetal.gymbuddy.viewbinding.ViewController
import mformetal.gymbuddy.viewbinding.find

class HomeViewController(private val viewModel: HomeViewModel) : Store.Listener<HomeState>, ViewController() {

    val fab by delegatedViewFinder.find<FloatingActionButton>(R.id.jump_to_today)

    override fun onViewsBound() {
        fab.setOnClickListener {
            viewModel.jumpToToday()
        }
    }

    override fun onNewState(state: HomeState) {

    }
}