package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.module.product.data.model.response.ProductDto
import com.example.quickstartlessons.module.product.data.model.response.ProductsDto
import com.example.quickstartlessons.module.user.data.response.UserDto
import com.example.quickstartlessons.module.user.data.response.UsersDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDataSource {
    @GET("products")
    suspend fun getProduct(): Response<ProductsDto>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Response<ProductDto>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products/category/{categoryName}")
    suspend fun getProductByCategory(@Path("categoryName") id: String): Response<ProductsDto>
    @GET("users")
    suspend fun getAllUsers():Response<UsersDto>
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int):Response<UserDto>
}