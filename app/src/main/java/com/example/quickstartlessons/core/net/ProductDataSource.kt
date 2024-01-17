package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.module.product.data.model.response.ProductsDto
import retrofit2.Response
import retrofit2.http.GET

interface ProductDataSource {
    @GET("products")
    suspend fun getProduct(): Response<ProductsDto>

}