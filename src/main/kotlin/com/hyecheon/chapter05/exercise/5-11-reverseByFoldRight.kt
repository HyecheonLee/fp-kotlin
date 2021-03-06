package com.hyecheon.chapter05.exercise

import com.hyecheon.chapter05.FunList
import com.hyecheon.chapter05.appendTail
import com.hyecheon.chapter05.foldRight
import com.hyecheon.chapter05.funListOf

/**
 *
 * 연습문제 5-11
 *
 * reverse 함수를 foldLeft 함수를 사용해서 재작성 해보자.
 *
 * 힌트: 함수의 선언 타입은 아래와 같다.
 *
 */

fun main() {
    val list = funListOf(1, 2, 3, 4, 5)
    require(list.reverseByFoldRight() == funListOf(5, 4, 3, 2, 1))
}

fun <T> FunList<T>.reverseByFoldRight(): FunList<T> = this.foldRight(FunList.Nil, { element, acc: FunList<T> ->
    acc.appendTail(element)
})