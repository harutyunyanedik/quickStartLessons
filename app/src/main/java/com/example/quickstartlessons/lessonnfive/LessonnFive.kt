package com.example.quickstartlessons.lessonnfive

fun main() {

}


inline fun <reified T> foo(number1: Int, number2: Int) {
    val result = number1 + number2
    println("foo")
    println(result)
}

fun foo(int: Int, boo: (String) -> Unit) {
    boo("aaa")
}

class IfStatement(private val truth: Boolean) {
    infix fun myElse(onFalse: () -> Unit) {
        if (!truth) onFalse()
    }
}

fun myIf(truth: Boolean, onTrue: () -> Unit): IfStatement {
    if (truth) onTrue()

    return IfStatement(truth)
}