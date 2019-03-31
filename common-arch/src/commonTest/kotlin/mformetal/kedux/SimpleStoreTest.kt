package mformetal.kedux

import io.mockk.mockk
import io.mockk.verify
import mformetal.kedux.SimpleStore
import mformetal.kedux.Store
import kotlin.test.Test

class SimpleStoreTest {

    val listener = mockk<Store.Listener<String>>()

    @Test
    fun `should receive initial state`() {
        val string = "test"
        val store = SimpleStore(string)
        store.addListener(listener)

        verify {
            listener.onNewState(string)
        }
    }

    @Test
    fun `should receive updated state`() {
        val store = SimpleStore("test1")
        store.addListener(listener)

        val updated = "test2"
        store.state = updated

        verify { listener.onNewState(updated) }
    }

    @Test
    fun `should not receive updated state after removing`() {
        val store = SimpleStore("test1")
        store.addListener(listener)

        store.removeListener(listener)
        store.state = "test2"

        verify(exactly = 1) { listener.onNewState(any()) }
    }

    @Test
    fun `should not call listener if state is equal`() {
        val initial = "test1"
        val store = SimpleStore(initial)
        store.addListener(listener)

        store.state = initial

        verify(exactly = 1) { listener.onNewState(initial) }
    }
}
