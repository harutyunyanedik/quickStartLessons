package com.example.quickstartlessons.lessonSeven

fun main() {
    val list1: MutableList<Car> = mutableListOf(Car("bmw", 2001), Car("bmw", 2010), Car("mercedes", 10), Car("mercedes", 19))
    val list2: MutableList<Any> = mutableListOf(Car("bmw", 2001), Car("bmw", 2010), Car("mercedes", 10), Car("mercedes", 19), "blaa")
//    val list: List<String> = listOf("aaa")
////
//    val car = list1.filter {
//        it.name == "bmw"
//    }
//
//    val car1 = list1.groupBy {
//        it.name
//    }
//
//    println(car1)
//
//    val li = car1.get("bmw")
//    val pair = Pair("", "")
//    pair.first
//    pair.second
//
//    val t = "test" to "test"
//    val map: Map<String, String> = mapOf("test" to "test")
//
//    val mutableMap: MutableMap<String?, String> = mutableMapOf()
//    mutableMap[null] = "string"
//    println(mutableMap[null])
//    mutableMap[null] = "str"
//    println(mutableMap[null])
//
//    val hashSet = hashSetOf<String?>()
//    hashSet.add(null)
//
//    val mMap = myMapOf("1" myTo 10, "2" to 20)
//    println("my map is $mMap")
//
//    val car6 = list1.myFind {
//        it.name == "bmw"
//    }
//
//    println(car6)
//

//    val string = list1.joinToString()


//    println("new list is ${list2.createNewList<String>()}")

//    val string = list1.joinToString()
//
//    list1.myFind {
//        it.name == "bmw"
//    }
//
//    list1.map {
//        it.name
//    }.also { println(it.toString()) }
//
//    list1.myFilter {
//        it.name == "bmw"
//    }.also { println(it) }

    val assosate = list1.groupBy {
        it.name
    }



    val integers = listOf(10,25, 30)
    println(integers.sum())

    println("new list is ${list2.createNewList<String>()}")

//    val string = list1.joinToString()
}

fun List<Int>.myIntersect(other: List<Int>): List<Int> {
    val set = this.toMutableSet()
    set.retainAll(other)
    return set.toList()
}

inline fun <reified T, reified E> myMapOf(vararg pair: Pair<T, E>): Map<T, E> {
    val map: MutableMap<T, E> = mutableMapOf()
    if (pair.isEmpty()) return emptyMap()

    pair.forEach {
        map[it.first] = it.second
    }
    return map
}

infix fun <T, E> T.myTo(e: E): Pair<T, E> {
    return Pair(this, e)
}

data class Car(val name: String, val year: Int)

inline fun <reified T> List<T>.myFind(condition: (T) -> Boolean): T? {
    for (element in this) {
        if (condition(element))
            return element
    }

    return null
}

inline fun <reified T> List<T>.myFilter(condition: (T) -> Boolean): List<T> {
    val list = mutableListOf<T>()
    for (element in this) {
        if (condition(element))
            list.add(element)
    }

    return list
}

fun myMap() {

}

fun <T, K> List<T>.myGroupBy(condition: (T) -> K): Map<K, List<T>> {
    val map: MutableMap<K, MutableList<T>> = mutableMapOf()

    this.forEach { element ->
        if (map.containsKey(condition(element))) {
            map[condition(element)]?.add(element)
        } else {
            map[condition(element)] = mutableListOf(element)
        }
    }
    return map
}

inline fun <reified T> List<*>.createNewList(): ArrayList<T> {
    val newArray = arrayListOf<T>()
    this.forEach { item ->
        if (item is T) {
            newArray.add(item)
        }
    }
    return newArray
}

enum class SportType(val id: Long) {
    Football(1),
    BasketBall(2),
    Tennis(4),
    TableTennis(6)
}