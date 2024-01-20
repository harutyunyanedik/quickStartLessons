package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.module.product.data.model.response.ProductsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDataSource {
    @GET("products")
    suspend fun getProduct(): Response<ProductsDto>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products/category/{categoryName}")
    suspend fun getProductByCategory(@Path("categoryName") id:String):Response<ProductsDto>
}