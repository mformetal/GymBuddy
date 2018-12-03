package kedux

import io.mockk.*
import kedux.middleware.Middleware
import utils.mock
import kotlin.test.Test

class DispatchersTest {

    val initialState = "bro"
    val store = mock<SimpleStore<String>> {
        every { state } returns initialState
    }
    val reducer = mock<Reducer<String, String>> {
        every { reduce(any(), any()) } returns "brah"
    }

    val dispatcher = Dispatcher.forStore(store, reducer)

    @Test
    fun `should set state on store with reducer`() {
        val action = "update"
        dispatcher.dispatch(action)

        verify {
            reducer.reduce(action, initialState)
            store.state = "brah"
        }
    }

    @Test
    fun `should run chained middleware`() {
        val middleWare = mock<Middleware<String, String>>()
        val chainedDispatcher = spyk(dispatcher.chain(middleWare))

        val action = "thing"
        chainedDispatcher.dispatch(action)

        verify {
            middleWare.dispatch(any(), action)
        }
    }

    @Test
    fun `should give next middleware upated state from dispatcher`() {
        val middleWare = mock<Middleware<String, String>>()
        val chainedDispatcher = spyk(dispatcher.chain(middleWare))

        val action = "thing"
        chainedDispatcher.dispatch(action)

        val slot = slot<Middleware.Next<String, String>>()
        verify {
            middleWare.dispatch(capture(slot), action)
        }
        slot.captured.next(action)
        verify(exactly = 1) {
            chainedDispatcher.dispatch(action)
        }
    }
}