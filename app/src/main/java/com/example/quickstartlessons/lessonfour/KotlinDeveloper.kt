package com.example.quickstartlessons.lessonfour

class KotlinDeveloper {

    private val request = Request()

    init {
        request.doRequest(object : RequestListener {
            override fun onSuccess() {

            }

            override fun onError() {

            }
        })
    }

}

interface RequestListener {
    fun onSuccess()
    fun onError()
}

class Request {
    fun doRequest(listener: RequestListener) {
        listener.onSuccess()
    }
}

fun main() {

}