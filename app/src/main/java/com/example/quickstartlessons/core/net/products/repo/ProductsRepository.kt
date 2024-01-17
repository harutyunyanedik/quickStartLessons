package com.example.quickstartlessons.core.net.products.repo

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.products.datasource.ProductDataSource
import com.example.quickstartlessons.core.net.products.dto.ProductDto
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.core.net.products.dto.ProductsDto
import retrofit2.Call


interface ProductsRepository {
    fun getProductsV1(): Call<ProductDto>

    suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean)

    fun getProductV1(id: Int): Call<ProductDto>

    suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)
}

class ProductsRepositoryImplementation(private val dataSource: ProductDataSource) : ProductsRepository {

    override fun getProductsV1(): Call<ProductDto> = dataSource.getProducts()


    override suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductsV2()
        }
    }

    override fun getProductV1(id: Int): Call<ProductDto> = dataSource.getProduct(id)

    override suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductV2(id)
        }
    }
}