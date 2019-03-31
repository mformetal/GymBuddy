package mformetal.gymbuddy.extensions

import io.mockk.verify
import mformetal.gymbuddy.utils.mock
import mformetal.gymbuddy.utils.never
import mformetal.gymbuddy.utils.once
import kotlin.test.Test

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