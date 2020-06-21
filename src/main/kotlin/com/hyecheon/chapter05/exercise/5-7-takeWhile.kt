package com.hyecheon.chapter05.exercise

import com.hyecheon.chapter05.*
import com.hyecheon.chapter05.FunList.Cons
import com.hyecheon.chapter05.FunList.Nil
import java.lang.IllegalArgumentException


/**
 * 연습문제 5-7
 *
 * 다음과 같이 동작하는 ``takeWhile`` 함수를 구현하자. 타입 ``T``를 입력받아 ``Boolean``을 반환하는 함수 ``p``를 받는다. 리스트의 앞에서부터 함수
 * ``p``를 만족하는 값들의 리스트를 반환한다.(모든 값이 함수 ``p``를 만족하지 않는다면 원본 ``List``를 반환). 이때 원본 리스트가 바뀌지 않고, 새로운
 * 리스트를 반환할 때 매번 리스트를 생성하지 않아야 한다.
 */
fun main() {

    val intList = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
    require(intList.takeWhile { it < 4 } == funListOf(1, 2, 3))
    require(intList.takeWhile { it < 2 } == funListOf(1))
    require(intList.takeWhile { it < 0 } == Nil)
}

tailrec fun <T> FunList<T>.takeWhile(acc: FunList<T> = Nil, p: (T) -> Boolean): FunList<T> = when (this) {
    Nil -> this
    is Cons -> if (p(head)) {
        tail.takeWhile(acc.addHead(head), p)
    } else {
        acc.reverse()
    }
}