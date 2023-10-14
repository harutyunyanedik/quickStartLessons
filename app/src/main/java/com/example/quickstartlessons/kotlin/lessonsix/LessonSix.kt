package com.example.quickstartlessons.kotlin.lessonsix

fun main() {
    val array = arrayOf("name", "surname")
    println(array addSpaseBetweenElements StringOperators.Underline)
}

fun Array<Int>.swapIndexes(indexOne: Int, indexTwo: Int): Array<Int> {
    this[indexOne] = this[indexTwo].also { this[indexTwo] = this[indexOne] }
    return this
}

infix fun Array<String>.addSpaseBetweenElements(operator: StringOperators): String {
    var result = ""
    for (i in this.indices) {
        result = if (i == this.size - 1) {
            result.plus(this[i])
        } else {
            result.plus(this[i].plus(operator.value))
        }
    }
    return result
}

enum class StringOperators(val value: String) {
    Underline("_"),
    Spase(" "),
    Line("-")
}

infix fun Array<String>.addBetweenElements(operator: StringOperators): String {
    val stringBuilder: StringBuilder = StringBuilder("")
    for (i in 0 until this.size - 1) {
        stringBuilder.append(this[i] + operator.value)
    }
    stringBuilder.append(this[size - 1])
    return stringBuilder.toString()
}

infix fun Int.upTo(to: Int): Array<Int> {
    if (this < to) {
        val range = Array(to + 1 - this) {
            this
        }
        for (i in range.indices) {
            range[i] = this + i
        }
        return range
    } else {
        throw IndexOutOfBoundsException()
    }
}

