package com.example.quickstartlessons.core.net.products.datasource

import com.example.quickstartlessons.core.net.products.dto.ProductsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDataSource{
    @GET("products")
    suspend fun getAlbumsV2(): Response<List<ProductsDto>>

    @GET("products/{id}")
    suspend fun getAlbumV2(@Path("id") id: Int): Response<ProductsDto>
}
