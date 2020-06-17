package com.hyecheon.chapter03.exercise

fun main() {
    require(1 == factorial(1))
    require(24 == factorial(4))
    require(5040 == factorial(7))
    require(3628800 == factorial(10))
}

private tailrec fun factorial(n: Int, acc: Int = 1): Int {
    return when (n) {
        0 -> acc
        else -> factorial(n - 1, acc * n)
    }
}