package mformetal.gymbuddy.kedux.v2

import mformetal.gymbuddy.expectations.runTest
import mformetal.gymbuddy.utils.*
import kotlin.test.Test

class CoroutinesStoreTest {

    val initialState = "initial"
    val store = CoroutinesStore(initialState)

    @Test
    fun `should receive initial state when observing`() = runTest {
        val subscriber = mock<suspend (String) -> Unit>()
    }
}