package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.core.data.ProductDto
import com.example.quickstartlessons.core.data.ProductsDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDataSource {

    @GET("products")
    fun getProducts(): Call<ProductsDto>

    @GET("products")
    suspend fun getProductsV2(): Response<ProductsDto>

    @GET("products/{id}")
    fun getProduct(@Path("id") id: Int): Call<ProductDto>

    @GET("products/{id}")
    suspend fun getProductV2(@Path("id") id: Int): Response<ProductDto>
}