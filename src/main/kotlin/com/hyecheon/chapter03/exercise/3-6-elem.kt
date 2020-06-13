package com.hyecheon.chapter03.exercise

import com.hyecheon.chapter03.head
import com.hyecheon.chapter03.tail

/**
 * 연습문제 3-6
 *
 * 입력값 n이 리스트에 존재하는지 확인하는 함수를 재귀로 작성해보자.
 *
 * 힌트: 함수의 선언 타입은 아래와 같다.
 * fun elem(n: Int, list: List<Int>): Boolean
 */

fun main() {
    require(elem(5, listOf(1, 3, 5)))
    require(!elem(5, listOf(1, 3, 7)))
}

private fun elem(num: Int, list: List<Int>): Boolean {
    return when {
        list.isEmpty() -> false
        else -> if (list.head() == num) true else elem(num, list.tail())
    }
}