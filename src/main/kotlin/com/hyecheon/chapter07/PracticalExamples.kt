package com.hyecheon.chapter07

fun main() {
    val product = { x: Int, y: Int -> x * y }

    val curriedProduct = product.curried()
    val maybeProductTen = Just(10).fmap(curriedProduct)

    println(maybeProductTen.fmap { it(5) })
    println(maybeProductTen.fmap { f: (Int) -> Int -> f(5) })
}

private fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = { p1: P1 -> { p2: P2 -> this(p1, p2) } }
