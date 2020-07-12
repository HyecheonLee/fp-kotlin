package com.hyecheon.chapter07

import com.hyecheon.chapter04.compose

fun main() {

    val f = { a: Int -> a + 1 }
    val g = { b: Int -> b * 2 }


    val nothingLeft = Nothing.fmap(f compose g)

    val nothingRight = Nothing.fmap(g).fmap(f)

    println(nothingLeft == nothingRight)

    val justLeft = Just(5).fmap(f compose g)

    val justRight = Just(5).fmap(g).fmap(f)
    println(justLeft == justRight)

    val tree = Node(1, Node(2, EmptyTree, EmptyTree), Node(3, EmptyTree, EmptyTree))

    println(EmptyTree.fmap(f compose g) == EmptyTree.fmap(g).fmap(f))
    println(tree.fmap(f compose g) == tree.fmap(g).fmap(f))

    println(Left("error").fmap(f compose g) == Left("error").fmap(g).fmap(f))
    println(Right(5).fmap(f compose g) == Right(5).fmap(g).fmap(f))
}