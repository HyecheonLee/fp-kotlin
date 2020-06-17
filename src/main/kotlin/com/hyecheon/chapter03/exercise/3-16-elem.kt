package com.hyecheon.chapter03.exercise

import com.hyecheon.head
import com.hyecheon.tail


/**
 * 연습문제 3-16
 *
 * 연습문제 3-6에서 작성한 ``elem`` 함수가 꼬리 재귀인지 확인해보자. 만약 꼬리 재귀가 아니라면 개선해보자.
 */

fun main() {
    require(elem(5, listOf(1, 3, 5)))
    require(!elem(5, listOf(1, 3, 7)))
}

private tailrec fun elem(element: Int, list: List<Int>): Boolean {
    return when {
        list.isEmpty() -> false
        list.head() == element -> true
        else -> elem(element, list.tail())
    }
}