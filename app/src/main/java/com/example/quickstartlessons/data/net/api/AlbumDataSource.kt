package com.example.quickstartlessons.data.net.api

import com.example.quickstartlessons.data.net.model.AlbumDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface AlbumDataSource {

    @GET("albums/1")
    fun getAlbums(): Call<AlbumDto>

    @GET("albums/1")
    suspend fun getAlbumsV2(): Response<AlbumDto>
}