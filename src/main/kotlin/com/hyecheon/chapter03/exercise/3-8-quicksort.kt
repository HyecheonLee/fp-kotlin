package com.hyecheon.chapter03.exercise

import com.hyecheon.head
import com.hyecheon.tail

/**
 * 연습문제 3-8
 *
 * 퀵정렬 알고리즘의 ``quicksort`` 함수를 작성해 보자.
 *
 * 힌트1: 퀵정렬 알고리즘의 동작 방식은 아래 위키를 참고하자.
 * https://en.wikipedia.org/wiki/Quicksort
 * 힌트2: 리스트를 분할하기 위해 함수 ``partition``을 활용하자.
 */

fun main() {
    require(listOf(1, 2, 3, 4, 5, 6, 7) == quicksort(listOf(5, 3, 7, 6, 2, 1, 4)))
}

private fun quicksort(list: List<Int>): List<Int> {
    return when {
        list.isEmpty() ->
            list
        else -> {
            val pivot = list.head()
            val (one, two) = list.tail().partition { it < pivot }
            return quicksort(one) + listOf(pivot) + quicksort(two)
        }
    }
}