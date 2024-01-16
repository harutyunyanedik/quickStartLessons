package com.example.quickstartlessons.core.net.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.ProductData
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.core.net.getHttpResponse


interface ProductRepository {
    suspend fun getProducts(resultCallback: ApiResultCallback<List<ProductData>?>, isShowLoader: Boolean)
}
class ProductRepositoryImplementation(private val dataSource: ProductDataSource) : ProductRepository {
    override suspend fun getProducts(resultCallback: ApiResultCallback<List<ProductData>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
         dataSource.getProduct()
        }
    }
}
