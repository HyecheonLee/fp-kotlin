package com.hyecheon.chapter06

import com.hyecheon.chapter05.FunList
import com.hyecheon.chapter05.addHead

fun main() {
    val reversed = reverse(FunList.Cons(1, FunList.Cons(2, FunList.Cons(3, FunList.Cons(4, FunList.Nil)))), FunList.Nil)
    println(reversed)
}

fun <T> reverse(list: FunList<T>, acc: FunList<T>): FunList<T> = when (list) {
    FunList.Nil -> acc
    is FunList.Cons -> reverse(list.tail, acc.addHead(list.head))
}