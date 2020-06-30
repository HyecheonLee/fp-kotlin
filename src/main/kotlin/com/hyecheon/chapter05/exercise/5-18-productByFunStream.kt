package com.hyecheon.chapter05.exercise

import com.hyecheon.chapter05.FunStream
import com.hyecheon.chapter05.foldLeft
import com.hyecheon.chapter05.funStreamOf

/**
 *
 * 연습문제 5-18
 *
 * FunList에서 작성했던 product 함수를 FunStream에도 추가하자.
 *
 * 힌트: 함수의 선언 타입은 아래와 같다.
 *
 */

fun main() {
    require(funStreamOf(1, 2, 3, 4, 5).product() == 1 * 2 * 3 * 4 * 5)
}

fun FunStream<Int>.product(): Int = foldLeft(1) { acc, i ->
    acc * i
}