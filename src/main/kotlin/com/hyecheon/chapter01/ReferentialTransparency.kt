package com.hyecheon.chapter01

var someName = "Joe"
fun hello1() = println("Hello $someName")
fun hello2(name: String) = println("Hello $name")

fun main() {
    val result = transparent("Joe")
    print(result)
}

fun transparent(name: String) = "Hello $name"
fun print(helloStr: String) = println(helloStr)