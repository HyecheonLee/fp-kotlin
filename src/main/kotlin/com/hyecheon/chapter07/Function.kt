package com.hyecheon.chapter07

import com.hyecheon.chapter04.compose

data class UnaryFunction<in T, out R>(val g: (T) -> R) : Functor<R> {
    override fun <B> fmap(f: (R) -> B) = UnaryFunction { x: T ->
        (f compose g)(x)
    }

    fun invoke(input: T): R = g(input)
}

fun main() {
    val f = { a: Int -> a + 1 }
    val g = { b: Int -> b * 2 }

    val fg = UnaryFunction(g).fmap(f)
    println(fg.invoke(5))

    val k = { x: Int -> Just(x) }
    val kg = UnaryFunction(g).fmap(k)
    println(kg.invoke(5))
}