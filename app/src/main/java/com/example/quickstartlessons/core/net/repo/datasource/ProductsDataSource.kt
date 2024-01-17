package com.example.quickstartlessons.core.net.repo.datasource

import com.example.quickstartlessons.core.net.repo.Model.ProductsDto
import com.example.quickstartlessons.core.net.repo.Model.ProductsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsDataSource {

    @GET("products")
    suspend fun getAllProducts(): Response <ProductsModel>

    @GET("products/{id}")
    suspend fun getProducts(@Path("id") id: Int): Response <ProductsDto>

}