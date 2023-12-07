package com.example.quickstartlessons.data

object Count {

    private var count = 0

    fun getCount() : Int = count

    fun addCount() {
        count++
    }
}