package expectations.widget

import android.widget.Button

actual typealias ButtonWidget = Button

actual fun ButtonWidget.setClickListener(function: (Widget) -> Unit) {
    setOnClickListener(function)
}