package com.example.quickstartlessons.core.net.products.datasource

import com.example.quickstartlessons.core.net.products.dto.ProductDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDataSource{

    @GET("products")
    fun getProducts(): Call<ProductDto>

    @GET("products")
    suspend fun getProductsV2(): Response<ProductDto>

    @GET("products/{id}")
    fun getProduct(@Path("id") id: Int): Call<ProductDto>

    @GET("products/{id}")
    suspend fun getProductV2(@Path("id") id: Int): Response<ProductDto>
}
