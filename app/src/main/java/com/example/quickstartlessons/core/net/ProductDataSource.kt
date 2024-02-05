package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.module.account.users.data.UsersDto
import com.example.quickstartlessons.module.products.data.ProductDto
import com.example.quickstartlessons.module.products.data.ProductsDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductDataSource {
    @GET("users")
    suspend fun getUsers(): Response<UsersDto?>

    @GET("products")
    fun getProducts(): Call<ProductsDto>

    @GET("products")
    suspend fun getProductsV2(): Response<ProductsDto>

    @GET("products/{id}")
    fun getProduct(@Path("id") id: Int): Call<ProductDto>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Response<ProductDto>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products/category/{categoryName}")
    suspend fun getProductsByCategory(@Path("categoryName") name: String): Response<ProductsDto>

    @GET("products")
    suspend fun getProductsByName(@Query("q") name: String) : Response<ProductsDto?>
}
