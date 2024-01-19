package com.example.quickstartlessons.core.net.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.module.product.data.model.response.ProductsDto
import com.example.quickstartlessons.core.net.getHttpResponse


interface ProductRepository { //todo rename Repository
    suspend fun getProducts(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)
    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean,id:String)
}

class ProductRepositoryImplementation(private val dataSource: ProductDataSource) : ProductRepository {

    override suspend fun getProducts(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProduct()
        }
    }

    override suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean, id: String) {
        getHttpResponse(resultCallback,isShowLoader) {
            dataSource.getCategories()
        }
    }
}
