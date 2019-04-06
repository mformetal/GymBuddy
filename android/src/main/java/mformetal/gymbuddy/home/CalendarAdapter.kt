package mformetal.gymbuddy.home

import mformetal.gymbuddy.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mformetal.gymbuddy.extensions.find
import mformetal.gymbuddy.extensions.inflater
import mformetal.gymbuddy.home.domain.CalendarModel

class CalendarAdapter : ListAdapter<CalendarModel, CalendarAdapter.CalendarViewHolder>(CalendarAdapter.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val root = parent.inflater.inflate(R.layout.calendar_model, parent, false)
        return CalendarViewHolder(root)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CalendarViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

        fun bind(model: CalendarModel) {
            root.find<TextView>(R.id.month).text = model.calendarName
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CalendarModel>() {
            override fun areItemsTheSame(oldItem: CalendarModel, newItem: CalendarModel): Boolean {
                return oldItem.calendarName == newItem.calendarName
            }

            override fun areContentsTheSame(oldItem: CalendarModel, newItem: CalendarModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}