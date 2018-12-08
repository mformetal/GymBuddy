package expectations

import platform.UIKit.UILabel

actual typealias TextWidget = UILabel

actual var TextWidget.body: String
    get() = text ?: ""
    set(value) {
        text = value
    }