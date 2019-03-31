package mformetal.ktest

import mformetal.ktest.shouldEqual

fun String.assertEmpty() {
    length shouldEqual 0
}