package com.example.quickstartlessons.core.net.repo.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.core.net.repo.Model.ProductsDto
import com.example.quickstartlessons.core.net.repo.datasource.ProductsDataSource
import com.example.quickstartlessons.core.net.repo.Model.ProductsModel


interface ProductsRepository {

    suspend fun getAllProducts(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean)

    suspend fun getProducts(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int)

}

class ProductRepositoryImplementation(private val dataSource: ProductsDataSource) : ProductsRepository {

    override suspend fun getAllProducts(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAllProducts()
        }
    }

    override suspend fun getProducts(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProducts(id)
        }
    }
}