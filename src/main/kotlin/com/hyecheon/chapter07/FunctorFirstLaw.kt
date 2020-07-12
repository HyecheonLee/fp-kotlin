package com.hyecheon.chapter07

fun main() {

    println(Nothing.fmap { identity(it) } == identity(Nothing))
    println(Just(5).fmap { identity(it) } == identity(Just(5)))

    val tree = Node(1, Node(2, EmptyTree, EmptyTree), Node(3, EmptyTree, EmptyTree))

    println(EmptyTree.fmap { identity(it) } == identity(EmptyTree))
    println(tree.fmap { identity(it) } == identity(tree))
    
    // Either 1 laws
    println(Left("error").fmap { identity(it) } == identity(Left("error"))) // true
    println(Right(5).fmap { identity(it) } == identity(Right(5))) // true

}

fun <T> identity(x: T): T = x