package com.hyecheon.chapter03.exercise


/**
 * 연습문제 3-10
 *
 * 연습문제 3-3에서 작성한 ``factorial`` 함수를 메모이제이션을 사용해서 개선해 보라.
 */

fun main() {
    require(1 == factorial(1))
    require(24 == factorial(4))
    require(5040 == factorial(7))
    require(3628800 == factorial(10))
}

private fun factorial(n: Int): Int {
    val memo = Array(n + 1) { -1 }
    fun memoFactorial(n: Int): Int {
        return when (n) {
            0 -> 1
            else -> {
                if (memo[n] == -1) {
                    memo[n] = memoFactorial(n - 1) * n
                }
                return memo[n]
            }
        }
    }
    return memoFactorial(n)
}