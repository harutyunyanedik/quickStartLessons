package com.example.quickstartlessons.tablayout

import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Response
import retrofit2.http.GET

interface ProductDataSource {
    @GET("albums/1")
    suspend fun getProduct(): Response<Product>
}