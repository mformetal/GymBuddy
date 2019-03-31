package mformetal.gymbuddy.home

import android.graphics.Color
import android.view.Gravity
import android.view.View
import mformetal.gymbuddy.kedux.Store

class HomeViewController(private val viewModel: HomeViewModel) : Store.Listener<HomeState> {

    override fun onNewState(state: HomeState) {
//        calendar.setCurrentMonthYearText(state.currentMonthYearText)
    }
}