package com.example.quickstartlessons.homework

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoDataSource {
    @GET("photos/{id}")
    fun getPhotos():Response <List<Photo>>
}