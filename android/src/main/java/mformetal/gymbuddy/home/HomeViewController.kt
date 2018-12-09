package mformetal.gymbuddy.home

import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import mformetal.gymbuddy.kedux.ViewController

class HomeViewController(private val viewModel: HomeViewModel) : ViewController<HomeState>, AnkoComponent<HomeActivity> {

    private lateinit var calendar: CollapsibleCalendarView

    override fun createView(ui: AnkoContext<HomeActivity>): View = ui.apply {
        frameLayout {
            lparams(width = matchParent, height = matchParent)

            calendar = collapsibleCalendar(viewModel) {

            }.lparams(width = matchParent, height = wrapContent) {
                gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            }
        }
    }.view

    override fun render(state: HomeState) {
        calendar.setCurrentMonthYearText(state.currentMonthYearText)
    }
}