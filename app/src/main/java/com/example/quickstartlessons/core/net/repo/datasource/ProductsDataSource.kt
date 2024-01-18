package com.example.quickstartlessons.core.net.repo.datasource

import com.example.quickstartlessons.module.products.data.response.model.CategoryModel
import com.example.quickstartlessons.module.products.data.response.model.ProductsDto
import com.example.quickstartlessons.module.products.data.response.model.ProductsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsDataSource {

    @GET("products")
    suspend fun getAllProducts(): Response <ProductsModel>

    @GET("products/{id}")
    suspend fun getProducts(@Path("id") id: Int): Response <ProductsDto>

    @GET("products/categories")
    suspend fun getAllCategories(): Response <List<String>>

    @GET("products/categories/{id}")
    suspend fun getCategories(@Path("id") id: Int): Response <String>

}