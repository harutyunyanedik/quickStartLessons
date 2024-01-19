package com.example.quickstartlessons.core.net.repo.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.products.data.response.model.ProductsDto
import com.example.quickstartlessons.core.net.repo.datasource.HomeMainTabDataSource
import com.example.quickstartlessons.module.products.data.response.model.ProductsModel

interface ProductsRepository {   // todo rename to repository

    suspend fun getAllProducts(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean)

    suspend fun getProducts(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int)

    suspend fun getAllCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

    suspend fun getCategories(resultCallback: ApiResultCallback<String?>, isShowLoader: Boolean, id: Int)

}

class ProductRepositoryImplementation(private val dataSource: HomeMainTabDataSource) : ProductsRepository {

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

    override suspend fun getAllCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAllCategories()
        }
    }

    override suspend fun getCategories(resultCallback: ApiResultCallback<String?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getCategories(id)
        }
    }

}