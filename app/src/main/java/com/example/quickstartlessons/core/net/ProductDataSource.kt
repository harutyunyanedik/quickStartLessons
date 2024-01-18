package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.module.data.ProductDto
import com.example.quickstartlessons.module.data.ProductsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDataSource {

    @GET("products/category/{categoryName}")
    suspend fun getProductsByCategory(@Path("categoryName") name: String): Response<ProductsDto>
    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products")
    suspend fun getProductsV2(): Response<ProductsDto>


    @GET("products/{id}")
    suspend fun getProductV2(@Path("id") id: Int): Response<ProductDto>
}