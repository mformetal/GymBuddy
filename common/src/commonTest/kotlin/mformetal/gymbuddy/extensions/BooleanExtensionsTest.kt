import io.mockk.verify
import mformetal.gymbuddy.extensions.takeIfFalse
import kotlin.test.Test

import mformetal.ktest.assertPresent
import mformetal.ktest.assertNull
import mformetal.ktest.assertEmpty

class BooleanExtensionsTest {

    @Test
    fun `should execute function if false`() {
        val boolean = false
        val function = {
            ""
        }

        val result = boolean.takeIfFalse(function)

        result.assertPresent {
            it.assertEmpty()
        }
    }

    @Test
    fun `should not execute function if true`() {
        val boolean = true
        val function = {
            ""
        }

        val result = boolean.takeIfFalse(function)

        result.assertNull()
    }
}