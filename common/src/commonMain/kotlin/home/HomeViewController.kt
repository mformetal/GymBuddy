package home

import expectations.TextWidget
import expectations.Widget
import expectations.body

abstract class HomeViewController {

    protected lateinit var textWidget: TextWidget

    abstract fun createView(any: Any) : Widget

    fun setMessage(message: String) {
        textWidget.body = message
    }
}