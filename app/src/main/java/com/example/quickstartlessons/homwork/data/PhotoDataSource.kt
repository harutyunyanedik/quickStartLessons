package com.example.quickstartlessons.homwork.data

import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoDataSource {
    @GET("photos")
    fun getPhoto(): Call<List<Photo>>
    @GET("photos/{photo_id}")
    suspend fun getPhotos(
        @Path("photo_id") albumId:Int
    ): Response<List<Photo>>
}
