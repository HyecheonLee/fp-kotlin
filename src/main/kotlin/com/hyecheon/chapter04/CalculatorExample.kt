package com.hyecheon.chapter04

fun main() {
    // OOP 예제
    val calcSum = Sum()
    val calcMinus = Minus()
    val calcProduct = Product()


    println(calcSum.calc(1, 5))     // 6
    println(calcMinus.calc(5, 2))   // 3
    println(calcProduct.calc(4, 2)) // 8

    //고차함수를 사용한 예
    val sum = { x: Int, y: Int -> x + y }
    val minus = { x: Int, y: Int -> x - y }
    val product = { x: Int, y: Int -> x * y }
    println(higherOrder(sum, 1, 5))
    println(higherOrder(minus, 5, 2))
    println(higherOrder(product, 4, 2))
    /*4-4*/
    val calcTwiceSum = TwiceSum()
    println(calcTwiceSum.calc(8, 2))
    /*4-5*/
    val twiceSum = { x: Int, y: Int -> (x + y) * 2 }
    println(higherOrder(twiceSum, 8, 2))

}

fun higherOrder(func: (Int, Int) -> Int, x: Int, y: Int): Int = func(x, y)
interface Calcable {
    fun calc(x: Int, y: Int): Int
}

class Sum : Calcable {
    override fun calc(x: Int, y: Int): Int {
        return x + y
    }
}

class Minus : Calcable {
    override fun calc(x: Int, y: Int): Int {
        return x - y
    }
}

class Product : Calcable {
    override fun calc(x: Int, y: Int): Int {
        return x * y
    }
}

/*4-4*/
class TwiceSum : Calcable {
    override fun calc(x: Int, y: Int): Int {
        return (x + y) * 2
    }

}