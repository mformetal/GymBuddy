package utils

import io.mockk.mockk
import io.mockk.mockkConstructor

inline fun <reified T : Any> mock(block: T.() -> Unit = {}) = mockk(block = block)