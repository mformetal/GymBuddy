package mformetal.gymbuddy.home

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.soywiz.klock.Month
import mformetal.gymbuddy.R
import mformetal.gymbuddy.kedux.state.AppState
import mformetal.gymbuddy.android.viewbinding.AndroidController
import mformetal.gymbuddy.android.viewbinding.find
import mformetal.gymbuddy.home.domain.CalendarModel

class HomeAndroidController(private val viewModel: HomeViewModel) : AndroidController() {

    private val adapter = CalendarAdapter()
    private val recycler by delegatedViewFinder.find<RecyclerView>(R.id.recycler)

    override fun onViewsBound() {
        with (recycler) {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = this@HomeAndroidController.adapter
            PagerSnapHelper().attachToRecyclerView(this)
        }
    }

    override val render : (AppState) -> Unit = {
        val itemList = Month.values().map {
            CalendarModel(it.localName.capitalize())
        }
        adapter.submitList(itemList)
    }
}