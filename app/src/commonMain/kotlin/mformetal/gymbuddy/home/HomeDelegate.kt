package mformetal.gymbuddy.home

import expectations.widget.TextWidget
import expectations.widget.body
import kedux.Store

class HomeDelegate(private val viewModel: HomeViewModel,
                   private val widgetFinder: HomeDelegateViewFinder) {

    lateinit var text: TextWidget

    fun bind() {
        widgetFinder.findContent(this)
    }

    fun onViewLoaded() {
        viewModel.listen(listener)
    }

    fun onViewDestroyed() {
        viewModel.ignore(listener)
    }

    private val listener : Store.Listener<HomeState> = object : Store.Listener<HomeState> {
        override fun onNewState(state: HomeState) {
            text.body = state.text
        }
    }
}