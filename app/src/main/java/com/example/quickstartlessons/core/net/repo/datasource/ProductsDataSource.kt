package com.example.quickstartlessons.core.net.repo.datasource

import com.example.quickstartlessons.module.account.responceModel.UsersDto
import com.example.quickstartlessons.module.account.responceModel.UsersModel
import com.example.quickstartlessons.module.settings.model.products.ProductsDto
import com.example.quickstartlessons.module.settings.model.products.ProductsModel
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

    @GET("users")
    suspend fun getAllUsers(): Response <UsersModel>

    @GET("users/{id}")
    suspend fun getUser(@Path("id")id: Int): Response <UsersDto>
}