package com.example.quickstartlessons.data.net.api

import com.example.quickstartlessons.data.net.model.AlbumDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private fun setupRetrofit() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(AlbumDataSource::class.java)
    val call = apiService.getAlbums()
    call.enqueue(object : Callback<AlbumDto?> {
        override fun onResponse(call: Call<AlbumDto?>, response: Response<AlbumDto?>) {
            if (response.isSuccessful) {
                val data = response.body()
                println(data)
            } else {
                // show popup
            }
        }

        override fun onFailure(call: Call<AlbumDto?>, t: Throwable) {
            // show dialog
        }
    })
}