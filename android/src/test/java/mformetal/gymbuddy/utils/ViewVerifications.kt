package mformetal.gymbuddy.utils

import android.view.View
import io.mockk.slot
import io.mockk.verify
import mformetal.gymbuddy.kedux.middleware.Middleware

fun View.assertAndInvokeClickListener(onClicked: () -> Unit = { }) {
    val slot = slot<View.OnClickListener>()

    verify {
        setOnClickListener(capture(slot))
    }

    slot.captured.onClick(this@assertAndInvokeClickListener)

    onClicked()
}