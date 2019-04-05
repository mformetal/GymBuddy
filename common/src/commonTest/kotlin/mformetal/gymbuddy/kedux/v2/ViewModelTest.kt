package mformetal.gymbuddy.kedux.v2

import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ReceiveChannel
import mformetal.gymbuddy.kedux.arch.Store
import mformetal.gymbuddy.kedux.arch.ViewModel
import mformetal.gymbuddy.utils.mock
import kotlin.test.Test

class ViewModelTest {


    val state = "bro"
    val receiveChannel = mock<ReceiveChannel<String>>()
    val store = mock<Store<String>>().apply {
        every { receive() } returns receiveChannel
    }
    val receiver = mock<(String) -> Unit>()
    val ioDispatcher = Dispatchers.Default
    val uiDispatcher = Dispatchers.Default
    val viewModel = ViewModel(store, uiDispatcher, ioDispatcher)

    @Test
    fun `should subscribe to store`() {
        viewModel.subscribe(receiver)


        verify {
            store.receive()
        }
    }

    @Test
    fun `should receive state updates`() {
        viewModel.subscribe(receiver)

        coVerify {
            store.receive().consumeEach(captureLambda())
        }
    }
}