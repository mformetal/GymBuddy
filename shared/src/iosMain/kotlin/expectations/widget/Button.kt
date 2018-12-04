package expectations.widget

import platform.UIKit.UIButton

actual typealias ButtonWidget = UIButton

actual fun ButtonWidget.setClickListener(function: (Widget) -> Unit) {
    TODO()
}