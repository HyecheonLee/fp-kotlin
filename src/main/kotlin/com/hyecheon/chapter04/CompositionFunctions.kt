package com.hyecheon.chapter04

fun main() {
    println(composed(3))

    val addThree = { i: Int -> i + 3 }
    val twice = { i: Int -> i * 2 }
    val composedFunc = addThree compose twice
    println(composedFunc(3))

    val absolute = { i: List<Int> -> i.map { it -> kotlin.math.abs(it) } }
    val negative = { i: List<Int> -> i.map { it -> -it } }
    val minimum = { i: List<Int> -> i.min() }

    minimum(negative(absolute(listOf(3, -1, 5, -2, -4, 8, 14))))

    val composed = minimum compose negative compose absolute
    val result2 = composed(listOf(3, -1, 5, -2, -4, 8, 14))
}

fun composed(i: Int) = addThree(twice(i))
private fun addThree(i: Int) = i + 3
private fun twice(i: Int) = i * 2

infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
    return { gInput: G -> this(g(gInput)) }
}

