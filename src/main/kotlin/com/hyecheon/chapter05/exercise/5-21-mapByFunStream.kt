package com.hyecheon.chapter05.exercise

import com.hyecheon.chapter05.*

/**
 *
 * 연습문제 5-21
 *
 * FunList에서 작성했던 map 함수를 FunStream에도 추가하자.
 *
 * 힌트: 함수의 선언 타입은 아래와 같다.
 *
 */

fun main() {
    require(funStreamOf(1, 2, 3, 4, 5).map { it * 2 } == funStreamOf(2, 4, 6, 8, 10))
    require((1..100000000).toFunStream().map { it * it }
        .filter { it > 100 }
        .getHead() == 121)
}

fun <T, R> FunStream<T>.map(f: (T) -> R): FunStream<R> = when (this) {
    FunStream.Nil -> FunStream.Nil
    is FunStream.Cons -> FunStream.Cons({ f(getHead()) }, { getTail().map(f) })
}