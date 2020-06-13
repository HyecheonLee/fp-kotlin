package com.hyecheon.chapter01

fun main() {
    println(impureFunction(1, 2))
    z = 20
    println(impureFunction(1, 2))

    println(impureFunction(1, 2))   // 13
    println(impureFunctionWithSideEffect(10, 20))   // 30
    println(impureFunction(1, 2))   // 23
}

fun pureFunction(x: Int, y: Int) = x + y
var z = 10
fun impureFunction(x: Int, y: Int) = x + y + z

fun impureFunctionWithSideEffect(x: Int, y: Int): Int {
    z = y
    return x + y
}

data class MutablePerson(var name: String, var age: Int)

fun addAge(person: MutablePerson, num: Int) {
    person.age += num
}

data class ImmutablePerson(val name: String, val age: Int)

fun addAge(person: ImmutablePerson, num: Int) = ImmutablePerson(person.name, person.age + num)
