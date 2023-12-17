package com.example.quickstartlessons.homework

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoApi {
    @GET("photos/{id}")
    suspend  fun getPhotos(@Path("id")id :Int): Call<List<Photo>>
}