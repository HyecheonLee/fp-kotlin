package com.hyecheon.chapter06

interface Developer {
    val language: String
    fun writeCode() {
        println("write $language")
    }
}

interface Backend : Developer {
    fun operateEnvironment(): String {
        return "operateEnvironment"
    }

    override val language: String
        get() = "Haskell"
}

interface Frontend : Developer {
    fun drawUI(): String {
        return "drawUI"
    }

    override val language: String
        get() = "Elm"
}

class FullStack : Frontend, Backend {
    override val language: String
        get() = super<Frontend>.language + super<Backend>.language
}

fun main() {
    val frontend = object : Frontend {}
    val backend = object : Backend {}

    frontend.writeCode()
    backend.writeCode()

    val fullStack = FullStack()

    fullStack.writeCode()
    println(fullStack.drawUI())
    println(fullStack.operateEnvironment())
}