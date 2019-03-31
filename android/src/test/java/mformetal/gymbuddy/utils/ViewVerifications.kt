package mformetal.gymbuddy.utils

import android.view.View
import io.mockk.slot
import io.mockk.verify

fun View.verifyClicks(onClicked: () -> Unit = { }) {
    val slot = slot<View.OnClickListener>()

    verify {
        setOnClickListener(capture(slot))
    }

    slot.captured.onClick(this@verifyClicks)

    onClicked()
}