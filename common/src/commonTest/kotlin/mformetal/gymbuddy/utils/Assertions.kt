package mformetal.gymbuddy.utils

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

fun Any?.assertNull() {
    assertNull(this)
}

fun <T : Any> T?.assertPresent(onPresent: (T) -> Unit = { }) {
    assertNotNull(this)

    onPresent(this)
}

infix fun <T> T.shouldEqual(other: T) {
    assertEquals(this, other)
}