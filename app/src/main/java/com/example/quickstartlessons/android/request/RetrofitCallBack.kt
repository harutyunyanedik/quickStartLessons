package com.example.quickstartlessons.android.request

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


inline fun <reified T> Call<T>.execute(noinline onError:(String)->Unit = {}, noinline onSuccess:(T?)->Unit){
    this.enqueue(object :Callback<T>{
        override fun onResponse(call: Call<T>, response: Response<T>) {
           if(response.isSuccessful){
               onSuccess.invoke(response.body())
           }
            else{
                onError.invoke(response.errorBody().toString())
           }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            t.localizedMessage?.let { onError.invoke(it) }
        }

    })

}