package mformetal.gymbuddy.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewManager
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet.PARENT_ID
import mformetal.gymbuddy.R
import mformetal.gymbuddy.extensions.generateId
import mformetal.gymbuddy.extensions.getResourceIdAttribute
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

fun ViewManager.collapsibleCalendar(viewModel: HomeViewModel, init: CollapsibleCalendarView.() -> Unit) : CollapsibleCalendarView {
    return ankoView({ CollapsibleCalendarView(viewModel, it) }, theme = 0, init = init)
}

@SuppressLint("ViewConstructor")
class CollapsibleCalendarView @JvmOverloads constructor(
        private val viewModel: HomeViewModel,
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var nextButton: ImageButton
    private lateinit var previousButton: ImageButton
    private lateinit var currentMonthView: TextView

    init {
        AnkoContext.createDelegate(this).apply {
            constraintLayout {
                previousButton = themedImageButton(R.drawable.chevron_left, R.style.Widget_AppCompat_Button_Borderless) {
                    generateId()

                    backgroundResource = context.getResourceIdAttribute(R.attr.selectableItemBackgroundBorderless)

                    onClick {

                    }
                }.lparams(wrapContent, wrapContent)

                nextButton = themedImageButton(R.drawable.chevron_right, R.style.Widget_AppCompat_Button_Borderless) {
                    generateId()

                    backgroundResource = context.getResourceIdAttribute(R.attr.selectableItemBackgroundBorderless)

                    onClick {

                    }
                }.lparams(wrapContent, wrapContent)

                currentMonthView = textView(viewModel.currentMonthYearString) {
                    generateId()
                    gravity = Gravity.CENTER
                    textAppearance = R.style.TextAppearance_AppCompat_Body2
                }.lparams(wrapContent, wrapContent)

                applyConstraintSet {
                    previousButton {
                        connect(
                                TOP to TOP of PARENT_ID,
                                LEFT to LEFT of PARENT_ID
                        )
                    }

                    nextButton {
                        connect(
                                TOP to TOP of PARENT_ID,
                                RIGHT to RIGHT of PARENT_ID
                        )
                    }

                    currentMonthView {
                        connect(
                                TOP to TOP of PARENT_ID,
                                BOTTOM to BOTTOM of nextButton,
                                LEFT to RIGHT of previousButton,
                                RIGHT to LEFT of nextButton
                        )
                    }
                }
            }
        }
    }
}