package com.hyecheon.chapter07

import com.hyecheon.chapter04.compose
import kotlin.Nothing

sealed class MaybeCounter<out A> : Functor<A> {
    abstract override fun toString(): String
    abstract override fun <B> fmap(f: (A) -> B): Functor<B>
}

data class JustCounter<out A>(val value: A, val count: Int) : MaybeCounter<A>() {
    override fun <B> fmap(f: (A) -> B): MaybeCounter<B> = JustCounter(f(value), count + 1)
    override fun toString(): String = "JustCounter($value, $count)"
}

object NothingCounter : MaybeCounter<kotlin.Nothing>() {
    override fun toString(): String = "NothingCounter"
    override fun <B> fmap(f: (Nothing) -> B): Functor<B> = NothingCounter
}

fun main() {
    println(JustCounter(10, 3).fmap { it + 10 }.fmap { it * 2 })
    println(NothingCounter.fmap { x: Int -> x + 10 })

    // Functor's raws
    println(NothingCounter.fmap { identity(it) } == identity(NothingCounter))   // true
    println(JustCounter(5, 0).fmap { identity(it) } == identity(JustCounter(5, 0))) // false

    val f = { it: Int -> it + 1 }
    val g = { it: Int -> it * 2 }

    val nothingLeft = NothingCounter.fmap { f compose g }
    val nothingRight = NothingCounter.fmap(g).fmap(f)
    println(nothingLeft == nothingRight)    // true

    val justLeft = JustCounter(5, 0).fmap { f compose g }
    val justRight = JustCounter(5, 0).fmap(g).fmap(f)
    println(justLeft == justRight)  // false
}