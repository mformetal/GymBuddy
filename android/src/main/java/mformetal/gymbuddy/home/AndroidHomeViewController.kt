package mformetal.gymbuddy.home

import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*

class AndroidHomeViewController(private val viewModel: HomeViewModel) : HomeViewController, AnkoComponent<HomeActivity> {

    override fun createView(ui: AnkoContext<HomeActivity>): View = ui.apply {
        frameLayout {
            lparams(width = matchParent, height = matchParent)

            collapsibleCalendar(viewModel) {

            }.lparams(width = matchParent, height = wrapContent) {
                gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            }
        }
    }.view

    override fun render(homeState: HomeState) {

    }
}