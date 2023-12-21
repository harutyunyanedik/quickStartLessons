package com.example.quickstartlessons.module.albums.data.net.datasource

import com.example.quickstartlessons.module.albums.data.model.response.PhotoDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotosDataSource{
    @GET("photos")
    fun getAlbums(): Call<List<PhotoDto>>

    @GET("photos")
    suspend fun getAlbumsV2(): Response<List<PhotoDto>>

    @GET("photos/{id}")
    fun getAlbum(@Path("id") id: Int) : Call<PhotoDto>

    @GET("photos/{id}")
    suspend fun getAlbumV2(@Path("id") id: Int) : Response<PhotoDto>

}