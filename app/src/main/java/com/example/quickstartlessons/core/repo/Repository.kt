package com.example.quickstartlessons.core.repo

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.DataSource
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.product.data.net.response.ProductDto
import com.example.quickstartlessons.module.product.data.net.response.ProductsDto

interface Repository {

    suspend fun getProductById(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)

    suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)

    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

    suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, category: String)

    suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)
}

class ProductsRepositoryImplementation(private val dataSource: DataSource) : Repository {

    override suspend fun getProductById(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductById(id)
        }
    }

    override suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductsV2()
        }
    }

    override suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getCategories()
        }
    }

    override suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, category: String) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductsByCategory(category)
        }
    }

    override suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductV2(id)
        }
    }
}