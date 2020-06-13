package com.hyecheon.chapter01

fun doSomethingWithAny(any: Any) {

}

fun doSomethingWithAny(): Any {
    return Any()
}

var anyList: List<Any> = listOf(Any())

fun doSomething(func: (Int) -> String) {

}

fun doSomething(): (Int) -> String {
    return { value -> value.toString() }
}

var funcList: List<(Int) -> String> = listOf { value -> value.toString() }
