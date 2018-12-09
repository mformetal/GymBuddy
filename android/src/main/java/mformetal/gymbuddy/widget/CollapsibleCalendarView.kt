package mformetal.gymbuddy.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.PARENT_ID
import mformetal.gymbuddy.extensions.collapsibleCalendar
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.button
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.wrapContent

class CollapsibleCalendarView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        AnkoContext.createDelegate(this).apply {
            constraintLayout {
                val previousButton = button("PREV") {
                    id = View.generateViewId()

                    onClick {

                    }
                }.lparams(wrapContent, wrapContent)

                val nextButton = button("NEXT") {
                    id = View.generateViewId()

                    onClick {

                    }
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
                }
            }
        }
    }
}