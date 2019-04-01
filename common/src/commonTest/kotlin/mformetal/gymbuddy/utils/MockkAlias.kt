package mformetal.gymbuddy.utils

import io.mockk.mockk

internal inline fun <reified T : Any> mock(block: T.() -> Unit = {}) = mockk(block = block)