package mformetal.ktest

import io.mockk.mockk

inline fun <reified T : Any> mock(block: T.() -> Unit = {}) = mockk(block = block)