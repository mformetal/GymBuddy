package mformetal.gymbuddy.kedux.v2

import io.mockk.Ordering
import io.mockk.verify
import kotlinx.coroutines.channels.consumeEach
import mformetal.gymbuddy.expectations.runTest
import mformetal.gymbuddy.utils.assertNull
import mformetal.gymbuddy.utils.assertTrue
import mformetal.gymbuddy.utils.mock
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

    @Test
    fun `should receive state updates`() {
        val newState = "a"
        val receiveChannel = store.subscribe()

        store.update(newState)

        receiveChannel.poll() shouldEqual newState
    }

    @Test
    fun `should not receive state updates if channel is closed`() {
        val newState = "a"
        val receiveChannel = store.subscribe().apply {
            cancel()
        }

        store.update(newState)

        receiveChannel.poll().assertNull()
    }
}