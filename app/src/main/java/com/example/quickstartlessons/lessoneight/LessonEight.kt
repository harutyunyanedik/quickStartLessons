package com.example.quickstartlessons.lessoneight

import com.example.quickstartlessons.lessonSeven.createNewList

fun main() {

    val list: List<*> = listOf(10, "20", true, 30, "name", false, 3)
    val a = list.createNewList<Boolean>()
}

fun <T> List<T>.myFindV2(condition: (T) -> Boolean): T? {
    for (element in this) {
        if (condition(element)) {
            return element
        }
    }
    return null
}

fun <T> List<T>.myFilter(condition: (T) -> Boolean): List<T> {
    val list = mutableListOf<T>()
    for (element in this) {
        if (condition(element))
            list.add(element)
    }

    return list
}

inline fun <reified T, reified E> myMapOf(vararg pair: Pair<T, E>): Map<T, E> {
    val map: MutableMap<T, E> = mutableMapOf()
    if (pair.isEmpty()) return emptyMap()

    pair.forEach {
        map[it.first] = it.second
    }
    return map
}

