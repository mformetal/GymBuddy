package mformetal.gymbuddy.home

import io.mockk.mockk
import io.mockk.verify
import mformetal.gymbuddy.utils.TestViewFinder
import mformetal.gymbuddy.utils.assertAndInvokeClickListener
import org.junit.Before
import org.junit.Test

class HomeViewControllerTest {

    val viewModel = mockk<HomeViewModel>()

    val controller = HomeViewController(viewModel)

    @Before
    fun setUp() {
        controller.bind(TestViewFinder())
    }

    @Test
    fun `should issue request to jump to today`() {
        controller.fab.assertAndInvokeClickListener {
            verify {
                viewModel.jumpToToday()
            }
        }
    }
}
