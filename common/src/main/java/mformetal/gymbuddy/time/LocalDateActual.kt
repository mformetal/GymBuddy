package mformetal.gymbuddy.time

import org.threeten.bp.LocalDate

actual typealias Date = LocalDate

actual fun LocalDate.formatWith(formatter: DateTimeFormatter): String = format(formatter)

actual fun Date.formatWith(pattern: String): String = formatWith(createFormatter(pattern))

actual fun dateAtToday(): Date = LocalDate.now()