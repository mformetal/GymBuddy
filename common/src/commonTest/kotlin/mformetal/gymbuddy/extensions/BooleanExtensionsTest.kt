import io.mockk.verify
import mformetal.gymbuddy.extensions.takeIfFalse
import mformetal.gymbuddy.utils.assertEmpty
import mformetal.gymbuddy.utils.assertNull
import mformetal.gymbuddy.utils.assertPresent
import mformetal.gymbuddy.utils.mock
import kotlin.test.Test

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