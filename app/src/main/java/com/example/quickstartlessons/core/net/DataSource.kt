package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.module.postsmodel.data.net.responce.PostsDto
import com.example.quickstartlessons.module.product.data.net.response.ProductDto
import com.example.quickstartlessons.module.product.data.net.response.ProductsDto
import com.example.quickstartlessons.core.users.data.net.UsersDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DataSource {

    @GET("posts")
    suspend fun getPosts() : Response<PostsDto?>

    @GET("products/search")
    suspend fun search(@Query("q") name: String) : Response<ProductsDto?>

    @GET("users")
    suspend fun getUsers(): Response<UsersDto?>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int) : Response<ProductDto?>

    @GET("products/category/{categoryName}")
    suspend fun getProductsByCategory(@Path("categoryName") name: String): Response<ProductsDto>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products")
    suspend fun getProductsV2(): Response<ProductsDto>


    @GET("products/{id}")
    suspend fun getProductV2(@Path("id") id: Int): Response<ProductDto>
}