package com.example.quickstartlessons.data.net.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

inline fun <reified T> Call<T>.getHttpResult(
    noinline fail: (Throwable) -> Unit = {},
    noinline success: (T) -> Unit
) {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            fail(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            response.body()?.let {
                success(it)
            } ?: fail(Throwable())
        }

    })
}