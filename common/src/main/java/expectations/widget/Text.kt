package expectations.widget

import android.widget.TextView

actual typealias TextWidget = TextView

actual var TextWidget.body : String
    get() = text.toString()
    set(value) {
        text = value
    }