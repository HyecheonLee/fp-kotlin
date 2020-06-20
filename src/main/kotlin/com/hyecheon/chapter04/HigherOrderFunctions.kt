package com.hyecheon.chapter04

fun higherOrderFunction1(func: () -> Unit): Unit {
    func()
}

fun higherOrderFunction2(): () -> Unit {
    return { println("Hello, Kotlin") }
}

fun main() {
    higherOrderFunction1 { println("Hello, Kotlin") }   // Hello, Kotlin

    higherOrderFunction2()()                            // Hello, Kotlin
}