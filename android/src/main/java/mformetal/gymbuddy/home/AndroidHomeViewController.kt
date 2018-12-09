package mformetal.gymbuddy.home

import android.view.Gravity
import android.view.View
import expectations.Widget
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import strings.APP_NAME

class AndroidHomeViewController(private val viewModel: HomeViewModel) : HomeViewController(), AnkoComponent<HomeActivity> {

    @Suppress("UNCHECKED_CAST")
    override fun createView(any: Any): Widget = createView(any as AnkoContext<HomeActivity>)

    override fun createView(ui: AnkoContext<HomeActivity>): View = ui.apply {
        frameLayout {
            lparams(width = matchParent, height = matchParent)

            textView {
                gravity = Gravity.CENTER
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER
            }.also {
                textWidget = it
            }

            button(APP_NAME) {
                gravity = Gravity.CENTER

                onClick {
                    viewModel.onCounterClicked()
                }
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
            }
        }
    }.view
}