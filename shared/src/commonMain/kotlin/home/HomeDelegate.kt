package home

import expectations.widget.ButtonWidget
import expectations.widget.TextWidget
import expectations.widget.body
import expectations.widget.setClickListener
import kedux.Store

class HomeDelegate(private val viewModel: HomeViewModel,
                   private val widgetFinder: HomeDelegateViewFinder) {

    lateinit var text: TextWidget
    lateinit var button: ButtonWidget

    fun bind() {
        widgetFinder.findContent(this)

        button.setClickListener {
            viewModel.onCounterClicked()
        }
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