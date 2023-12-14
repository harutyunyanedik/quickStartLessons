package com.example.quickstartlessons.module.albums.data.net.datasource

import com.example.quickstartlessons.module.albums.data.model.responce.Albums
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface AlbumDataSource {
    @GET("albums/1")
    fun getAlbums(): Call<Albums>

    @GET("albums/1")
    suspend fun getAlbumsV2(): Response<Albums>

}