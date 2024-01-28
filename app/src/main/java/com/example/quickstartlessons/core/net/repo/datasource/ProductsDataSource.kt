package com.example.quickstartlessons.core.net.repo.datasource

import com.example.quickstartlessons.module.products.data.response.model.products.ProductsDto
import com.example.quickstartlessons.module.products.data.response.model.products.ProductsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsDataSource {

    @GET("products")
    suspend fun getAllProducts(): Response <ProductsModel>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Response <ProductsDto>

    @GET("products/categories")
    suspend fun getAllCategories(): Response <List<String>>

    @GET("products/categories/{id}")
    suspend fun getCategory(@Path("id") id: Int): Response <String>

    @GET("products/category/{categoryName}")
    suspend fun getProductsByCategory(@Path("categoryName") categoryName: String): Response <ProductsModel>
}