package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.module.data.ProductDto
import com.example.quickstartlessons.module.data.ProductsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDataSource {


    @GET("products")
    suspend fun getProductsV2(): Response<ProductsDto>


    @GET("products/{id}")
    suspend fun getProductV2(@Path("id") id: Int): Response<ProductDto>
}