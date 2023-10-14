package com.example.quickstartlessons.lessonnine

import java.util.Locale
import kotlin.reflect.KProperty

/**
 *  Exceptions, errors
 *  destructuring declarations
 *  lateinit
 *  Delegation
 *  Lazy delegation
 *  Delegated properties
 */

fun main() {
    val name by NameDelegate("john")
    val surname by NameDelegate("Smith")
}

class NameDelegate(private var delegated: String) {

    init {
        delegated = delegated.trim().uppercase()
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return delegated
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        if (value != null) {
            delegated = value.trim().toUpperCase(Locale.ROOT)
        }
    }
}

class User {
    var name: String? by NameDelegate("")

    var surname: String? by NameDelegate("")
}



