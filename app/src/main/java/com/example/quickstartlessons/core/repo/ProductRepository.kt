package com.example.quickstartlessons.core.repo

import com.example.quickstartlessons.module.data.ProductDto
import com.example.quickstartlessons.module.data.ProductsDto
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.core.net.getHttpResponse

interface ProductRepository {

    suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)

    suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)
}

class ProductsRepositoryImplementation(private val dataSource: ProductDataSource) : ProductRepository {

    override suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductsV2()
        }
    }

    override suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductV2(id)
        }
    }
}