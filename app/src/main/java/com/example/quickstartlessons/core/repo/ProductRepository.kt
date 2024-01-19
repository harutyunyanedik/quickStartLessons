package com.example.quickstartlessons.core.repo

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.data.ProductDto
import com.example.quickstartlessons.module.data.ProductsDto

interface ProductRepository {  // todo rename Repository

    suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)

    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

    suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, category: String)

    suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)
}

class ProductsRepositoryImplementation(private val dataSource: ProductDataSource) : ProductRepository {

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