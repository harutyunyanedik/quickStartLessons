package com.example.quickstartlessons.module.albums.data.net.datasource

import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumDataSource {
    @GET("photos")
    fun getAlbums(): Call<ArrayList<AlbumDto>?>?

    @GET("photos/{id}")
    suspend fun getAlbumsV2(
        @Path("id")id:Int
    ): Response<AlbumDto>

}
