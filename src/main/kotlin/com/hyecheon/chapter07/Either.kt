package com.hyecheon.chapter07

import java.lang.ArithmeticException
import kotlin.Nothing

private fun divideTenByN(n: Int): Either<String, Int> = try {
    Right(10 / n)
} catch (e: ArithmeticException) {
    Left("divide by zero")
}

sealed class Either<out L, out R> : Functor<R> {
    abstract override fun <R2> fmap(f: (R) -> R2): Either<L, R2>
}

data class Left<out L>(val value: L) : Either<L, Nothing>() {
    override fun <R2> fmap(f: (Nothing) -> R2): Either<L, R2> = this
}

data class Right<out R>(val value: R) : Either<Nothing, R>() {
    override fun <R2> fmap(f: (R) -> R2): Either<Nothing, R2> {
        return Right(f(value))
    }
}

fun main() {
    println(divideTenByN(5))
    println(divideTenByN(0))
    println(divideTenByN(5).fmap { r -> r * 2 })
    println(divideTenByN(0).fmap { r -> r * 2 })
}