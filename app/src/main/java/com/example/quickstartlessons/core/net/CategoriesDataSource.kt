package com.example.quickstartlessons.core.net

import retrofit2.Response
import retrofit2.http.GET

interface CategoriesDataSource {
    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>
}