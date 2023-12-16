package com.example.quickstartlessons.module.albums.data.net.datasource

import com.example.quickstartlessons.module.albums.data.model.response.PhotoDto
import com.example.quickstartlessons.module.albums.data.model.response.Photos
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PhotosDataSource {
    @GET("photos")
    fun getPhotos(): Call<Photos>
    @GET("photos{id}")
    fun getPhoto(): Call<PhotoDto>

    @GET("photos")
    suspend fun getAlbumsV2(): Response<Photos>

}