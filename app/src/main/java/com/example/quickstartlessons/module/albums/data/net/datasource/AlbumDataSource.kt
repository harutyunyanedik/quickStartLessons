package com.example.quickstartlessons.module.albums.data.net.datasource

import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumDataSource {
    @GET("albums/1")
    fun getAlbums(): Call<AlbumDto>

    @GET("albums/{album_id}")
    suspend fun getAlbumsV2(
        @Path("album_id")album_id:Int
    ): Response<AlbumDto>

}