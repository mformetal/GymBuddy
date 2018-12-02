package kedux

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNull

class DispatchersTest {

    @MockK lateinit var mockReducer : Reducer<SimpleEvents, SimpleState>

    @BeforeTest
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `test dispatching calls reducer`() {
        val state = SimpleState(0)
        every { mockReducer.reduce(any<SimpleEvents.EventOne>(), any()) } returns state
        val store = SimpleStore(state)
        val dispatcher = Dispatchers.create(store, mockReducer)
        val event = SimpleEvents.EventOne()

        dispatcher.dispatch(SimpleEvents.EventOne())

        assertNull(event)
    }

//    @Test
//    fun testDispatchingChangesStoreState() {
//        val state = SimpleState(0)
//        val secondState = SimpleState(1)
//        whenever(mockReducer.reduce(any<SimpleEvents.EventOne>(), any())).thenReturn(secondState)
//        val store = SimpleStore(state)
//        val dispatcher = Dispatchers.create(store, mockReducer)
//        dispatcher.dispatch(SimpleEvents.EventOne())
//        assert(store.state.ordinal).isEqualTo(1)
//    }
}