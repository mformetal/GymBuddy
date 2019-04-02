package mformetal.gymbuddy.kedux.v2

import mformetal.gymbuddy.expectations.runTest
import mformetal.gymbuddy.utils.shouldEqual
import kotlin.test.Test

class CoroutinesStoreTest {

    val initialState = "initial"
    val store = CoroutinesStore(initialState)

    @Test
    fun `should return initial state as given`() {
        store.state shouldEqual initialState
    }

    @Test
    fun `should update state`() = runTest {
        val newState = "newState"

        store.update(newState)

        store.state shouldEqual newState
    }
}