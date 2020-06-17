package com.hyecheon.chapter03.exercise

import com.hyecheon.chapter03.Bounce
import com.hyecheon.chapter03.Done
import com.hyecheon.chapter03.More
import com.hyecheon.chapter03.trampoline
import kotlin.math.sqrt

/**
 * 연습문제 3-18
 *
 * 연습문제 3-17에서 작성한 함수를 ``trampoline`` 함수를 사용하여 재작성해보자.
 */

fun main() {
    require(0.528685631720282 == trampoline(squareRoot(5.0)))
}

private fun squareRoot(n: Double): Bounce<Double> = when {
    n < 1 -> Done(n)
    else -> More { divideTwo(sqrt(n)) }
}

private fun divideTwo(n: Double): Bounce<Double> = when {
    n < 1 -> Done(n)
    else -> More { squareRoot(n / 2) }
}