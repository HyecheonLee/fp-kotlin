package com.hyecheon.chapter07


sealed class Maybe<out A> : Functor<A> {
    abstract override fun toString(): String
    abstract override fun <B> fmap(f: (A) -> B): Maybe<B>

    companion object
}

data class Just<out A>(val value: A) : Maybe<A>() {
    override fun <B> fmap(f: (A) -> B): Maybe<B> = Just(f(value))
    override fun toString(): String = "Just($value)"
}

object Nothing : Maybe<kotlin.Nothing>() {
    override fun toString(): String = "Nothing"
    override fun <B> fmap(f: (kotlin.Nothing) -> B): Maybe<B> = Nothing
}

fun main() {
    println(Just(10).fmap { it + 10 })
    println(Nothing.fmap { x: Int -> x + 10 })
}