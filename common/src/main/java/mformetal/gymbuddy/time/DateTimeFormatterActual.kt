package mformetal.gymbuddy.time

import org.threeten.bp.format.DateTimeFormatter

actual typealias DateTimeFormatter = DateTimeFormatter

actual fun createFormatter(pattern: String): DateTimeFormatter = DateTimeFormatter.ofPattern(pattern)