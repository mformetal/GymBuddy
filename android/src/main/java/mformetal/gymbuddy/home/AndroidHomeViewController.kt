package mformetal.gymbuddy.home

import android.content.res.Resources
import android.view.Gravity
import android.view.View
import android.view.ViewParent
import android.widget.CalendarView
import androidx.viewpager.widget.ViewPager
import expectations.Widget
import mformetal.gymbuddy.extensions.collapsibleCalendar
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onDateChange
import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZonedDateTime
import java.time.format.DateTimeFormatter

class AndroidHomeViewController(private val viewModel: HomeViewModel) : HomeViewController(), AnkoComponent<HomeActivity> {

    @Suppress("UNCHECKED_CAST")
    override fun createView(any: Any): Widget = createView(any as AnkoContext<HomeActivity>)

    override fun createView(ui: AnkoContext<HomeActivity>): View = ui.apply {
        frameLayout {
            lparams(width = matchParent, height = matchParent)

            collapsibleCalendar {

            }.lparams(width = matchParent, height = wrapContent)
        }
    }.view
}