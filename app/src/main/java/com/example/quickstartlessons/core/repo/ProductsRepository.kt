package com.example.quickstartlessons.core.repo

import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.module.data.ProductDto
import com.example.quickstartlessons.core.getHttpResponse
import com.example.quickstartlessons.module.data.ProductsDto
import retrofit2.Call


interface ProductsRepository {
    fun getProductsV1(): Call<ProductsDto>

    suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)

    fun getProductV1(id: Int): Call<ProductDto>

    suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)
}

class ProductsRepositoryImplementation(private val dataSource: ProductDataSource) : ProductsRepository {
    override fun getProductsV1(): Call<ProductsDto> = dataSource.getProducts()

    override suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean) {
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


