package com.hyecheon.chapter06

var toggle: Boolean = false

fun main() {
    toggle = true
    toggle = false

    caseLanguageInterface(Java())
    caseLanguageEnum(Language.KOTLIN)

}

interface LanguageInterface
class Java : LanguageInterface
class Kotlin : LanguageInterface
class Scala : LanguageInterface
class Haskell : LanguageInterface
enum class Language {
    JAVA, KOTLIN, SCALA, HASKELL
}

private fun caseLanguageInterface(language: LanguageInterface) = when (language) {
    is Java -> {

    }
    is Kotlin -> {

    }
    is Scala -> {

    }
    is Haskell -> {

    }
    else -> {
        throw IllegalArgumentException("invalid type : $language")
    }
}

private fun caseLanguageEnum(language: Language) = when (language) {
    Language.JAVA -> {

    }
    Language.KOTLIN -> {

    }
    Language.SCALA -> {

    }
    Language.HASKELL -> {

    }
}