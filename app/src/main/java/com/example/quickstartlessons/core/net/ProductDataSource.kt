package com.example.quickstartlessons.core.net

import retrofit2.Response
import retrofit2.http.GET

interface ProductDataSource {
    @GET("products")
    suspend fun getProduct(): Response<List<ProductData>>

}