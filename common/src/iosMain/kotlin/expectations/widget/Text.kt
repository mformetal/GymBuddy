package expectations.widget

import platform.UIKit.UILabel

actual typealias TextWidget = UILabel

actual var TextWidget.body : String
    get() = text.toString()
    set(value) {
        text = value
    }