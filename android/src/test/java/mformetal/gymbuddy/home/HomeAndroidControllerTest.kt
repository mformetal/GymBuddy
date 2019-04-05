package mformetal.gymbuddy.home

import io.mockk.mockk
import io.mockk.verify
import mformetal.gymbuddy.utils.TestViewFinder
import mformetal.gymbuddy.utils.verifyClicks
import org.junit.Before
import org.junit.Test

class HomeAndroidControllerTest {

    val viewModel = mockk<HomeViewModel>()

    val controller = HomeAndroidController(viewModel)

    @Before
    fun setUp() {
        controller.bind(TestViewFinder())
    }

    @Test
    fun `should issue request to jump to today`() {
        controller.fab.verifyClicks {
            verify {
                viewModel.jumpToToday()
            }
        }
    }
}
