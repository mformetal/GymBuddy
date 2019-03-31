package mformetal.gymbuddy.extensions

import kotlin.test.Test
import mformetal.ktest.mock
import mformetal.ktest.once
import mformetal.ktest.never

class AnyExtensionsTest {

    @Test
    fun `should invoke lambda if receiver is null`() {
        val receiver : String? = null
        val lambda = mock<() -> Unit>()

        receiver.takeIfNull(lambda)

        once { lambda.invoke() }
    }

    @Test
    fun `should not invoke lambda if receiver is not null`() {
        val receiver = ""
        val lambda = mock<() -> Unit>()

        receiver.takeIfNull(lambda)

        never { lambda.invoke() }
    }
}