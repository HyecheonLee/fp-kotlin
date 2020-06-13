package com.hyecheon.chapter01

val lazyValue: String by lazy {
    println("시간이 오래 걸리는 작업")
    "hello"
}

fun main() {
    println(lazyValue)
    println(lazyValue)
}
