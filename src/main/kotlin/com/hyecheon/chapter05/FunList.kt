package com.hyecheon.chapter05

import com.hyecheon.chapter05.FunList.Cons
import com.hyecheon.chapter05.FunList.Nil

sealed class FunList<out T> {
    object Nil : FunList<Nothing>()
    data class Cons<out T>(val head: T, val tail: FunList<T>) : FunList<T>()
}

fun <T> funListOf(vararg elements: T): FunList<T> = elements.toFunList()

private fun <T> Array<out T>.toFunList(): FunList<T> = when {
    this.isEmpty() -> Nil
    else -> {
        val tail = copyOfRange(1, this.size)
        Cons(first(), tail.toFunList())
    }
}

fun <T> FunList<T>.toFunStream(): FunStream<T> = when (this) {
    Nil -> FunStream.Nil
    else -> FunStream.Cons({ getHead() }, { getTail().toFunStream() })
}

fun FunList<Double>.product(): Double = when (this) {
    Nil -> 1.0
    is Cons -> if (head == 0.0) 0.0 else head * tail.product()
}

fun <T> FunList<T>.getTail(): FunList<T> = when (this) {
    Nil -> throw NoSuchElementException()
    is Cons -> tail
}

fun <T> FunList<T>.getHead(): T = when (this) {
    Nil -> throw NoSuchElementException()
    is Cons -> head
}

fun <T> FunList<T>.addHead(head: T): FunList<T> = Cons(head, this)


infix fun <T> FunList<T>.concat(value: FunList<T>): FunList<T> {
    tailrec fun innerAppend(listA: FunList<T>, listB: FunList<T>): FunList<T> = when (listA) {
        Nil -> listB
        is Cons -> innerAppend(listA.tail, listB.addHead(listA.head))
    }
    return innerAppend(this.reverse(), value)
}

fun <T> FunList<T>.appendTail(value: T): FunList<T> = when (this) {
    Nil -> Cons(value, Nil)
    is Cons -> Cons(head, tail.appendTail(value))
}

fun FunList<Int>.sum(): Int = foldLeft(0) { acc, x -> acc + x }

tailrec fun <T, R> FunList<T>.foldLeft(acc: R, f: (R, T) -> R): R = when (this) {
    Nil -> acc
    is Cons -> tail.foldLeft(f(acc, head), f)
}

tailrec fun <T> FunList<T>.filter(acc: FunList<T> = Nil, p: (T) -> Boolean): FunList<T> = when (this) {
    Nil -> acc.reverse()
    is Cons -> if (p(head)) tail.filter(acc.addHead(head), p) else tail.filter(acc, p)
}

fun <T, R> FunList<T>.foldRight(acc: R, f: (T, R) -> R): R = when (this) {
    Nil -> acc
    is Cons -> f(head, tail.foldRight(acc, f))
}


tailrec fun <T> FunList<T>.reverse(acc: FunList<T> = Nil): FunList<T> = when (this) {
    Nil -> acc
    is Cons -> tail.reverse(acc.addHead(head))
}

tailrec fun <T> FunList<T>.appendTail(value: T, acc: FunList<T> = Nil): FunList<T> = when (this) {
    Nil -> Cons(value, acc).reverse()
    is Cons -> tail.appendTail(value, acc.addHead(head))
}

tailrec fun <T, R> FunList<T>.map(acc: FunList<R> = Nil, f: (T) -> R): FunList<R> = when (this) {
    Nil -> acc.reverse()
    is Cons -> tail.map(acc.addHead(f(head)), f)
}


tailrec fun <T> FunList<T>.forEach(f: (T) -> Unit): Unit = when (this) {
    Nil -> Unit
    is Cons -> {
        f(head)
        tail.forEach(f)
    }
}

fun <T, R> FunList<T>.mapByFoldLeft(f: (T) -> R): FunList<R> = foldLeft(Nil) { acc: FunList<R>, x ->
    acc.appendTail(f(x))
}

fun <T, R> FunList<T>.mapByFoldRight(f: (T) -> R): FunList<R> = foldRight(Nil) { x, acc: FunList<R> ->
    acc.addHead(f(x))
}

tailrec fun <T1, T2, R> FunList<T1>.zipWith(
    f: (T1, T2) -> R,
    list: FunList<T2>,
    acc: FunList<R> = Nil
): FunList<R> = when {
    this === Nil || list === Nil -> acc.reverse()
    else -> getTail().zipWith(f, list.getTail(), acc.addHead(f(getHead(), list.getHead())))
}

tailrec fun IntProgression.toFunList(acc: FunList<Int> = FunList.Nil): FunList<Int> = when {
    step > 0 -> when {
        first > last -> acc.reverse()
        else -> ((first + step)..last step step).toFunList(acc.addHead(first))
    }
    else -> when {
        first >= last -> {
            IntProgression.fromClosedRange(first + step, last, step).toFunList(acc.addHead(first))
        }
        else -> {
            acc.reverse()
        }
    }
}