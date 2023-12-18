package com.example.quickstartlessons.homework

import retrofit2.Response
import retrofit2.http.GET

interface PhotoDataSource {
    @GET("photos")
    suspend fun getPhotos():Response <List<Photo>>
}