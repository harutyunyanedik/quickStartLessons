package com.example.quickstartlessons.module.albums.data.net.datasource

import com.example.quickstartlessons.module.albums.data.model.response.AlbumDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface AlbumDataSource {
    @GET("photos")
    fun getAlbums(): Call<AlbumDto>

    @GET("photos")
    suspend fun getAlbumsV2(): Response<AlbumDto>

}