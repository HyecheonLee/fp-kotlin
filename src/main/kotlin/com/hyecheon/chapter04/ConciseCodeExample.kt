package com.hyecheon.chapter04

fun main() {
    val ints = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    //명령형 프로그래밍 예
    val over10Values = ArrayList<Int>()

    for (element in ints) {
        val twiceInt = element * 2
        if (twiceInt > 10) {
            over10Values.add(twiceInt)
        }
    }
    println(over10Values)

    val result = ints.map { it * 2 }
        .filter { it > 10 }

    println(result)


}