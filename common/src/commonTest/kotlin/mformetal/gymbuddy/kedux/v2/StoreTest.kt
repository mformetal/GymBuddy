package mformetal.gymbuddy.kedux.v2

import mformetal.gymbuddy.kedux.arch.Store
import mformetal.gymbuddy.utils.shouldEqual
import kotlin.test.Test

class StoreTest {

    val initialState = "initial"
    val nextState = "bro"
    val nextStates = listOf("a", "b", "c")
    val store = Store(initialState)

    @Test
    fun `should contain initial state`() {
        val state = store.receiveChannel.poll()

        state shouldEqual initialState
    }

    @Test
    fun `should update state`() {
        store.update(nextState)

        store.receiveChannel.poll() shouldEqual nextState
    }

    @Test
    fun `should receive state updates on receive channel`() {
        val receiver = store.receiveChannel

        store.update(nextState)

        receiver.poll() shouldEqual nextState
    }
}