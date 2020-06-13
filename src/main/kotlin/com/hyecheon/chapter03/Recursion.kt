package com.hyecheon.chapter03

fun List<Int>.head() = first()
fun List<Int>.tail() = drop(1)

fun main() {
    println(maximum(listOf(1, 3, 2, 8, 4)))
    println(reverse("abcd"))
}

fun maximum(items: List<Int>): Int = when {
    items.isEmpty() -> error("empty list")
    1 == items.size -> items[0]
    else -> {
        val head = items.head()
        val tail = items.tail()
        val maxValue = maximum(tail)
        if (head > maxValue) head else maxValue
    }
}

fun String.head() = first()
fun String.tail() = drop(1)
fun reverse(str: String): String = when {
    str.isEmpty() -> ""
    else -> reverse(str.tail()) + str.head()
}

