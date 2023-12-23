package com.example.quickstartlessons.tablayout

import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDataSource {
    @GET("products/{id}")
    suspend fun getProduct(@Path("id")id:Int): Response<Product>
}