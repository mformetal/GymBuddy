package mformetal.gymbuddy.kedux.v2

import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import mformetal.gymbuddy.expectations.launchBackground
import mformetal.gymbuddy.expectations.launchBlocking
import mformetal.gymbuddy.utils.assertNull
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
    fun `should update state`() = launchBlocking {
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

    @Test
    fun `should receive initial state when subscribed`() = launchBlocking { scope ->
        store.subscribe().apply {
            consumeEach { state ->
                state shouldEqual initialState
                cancel()
            }
        }
    }
}