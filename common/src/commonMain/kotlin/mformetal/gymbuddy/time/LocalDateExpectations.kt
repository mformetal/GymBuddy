package mformetal.gymbuddy.time

expect class Date

expect fun dateAtToday() : Date

expect fun Date.formatWith(formatter: DateTimeFormatter) : String

expect fun Date.formatWith(pattern: String) : String