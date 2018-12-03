package expectations.widget

import android.view.View

actual typealias Widget = View

actual fun Widget.find(id: Int) : Widget = findViewById(id)