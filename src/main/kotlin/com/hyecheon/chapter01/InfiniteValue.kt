package com.hyecheon.chapter01


fun main() {
    val infiniteValue = generateSequence(0) { it + 5 }
    infiniteValue.take(5).forEach { i -> println("$i ") }
}