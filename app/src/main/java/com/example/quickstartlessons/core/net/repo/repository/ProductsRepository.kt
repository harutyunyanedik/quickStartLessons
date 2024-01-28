package com.example.quickstartlessons.core.net.repo.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.core.net.repo.datasource.ProductsDataSource
import com.example.quickstartlessons.module.products.data.response.model.products.ProductsDto
import com.example.quickstartlessons.module.products.data.response.model.products.ProductsModel

interface ProductsRepository {

    suspend fun getAllProducts(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean)

    // todo rename getProduct to getProductById
    suspend fun getProduct(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int)

    suspend fun getAllCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

    suspend fun getCategories(resultCallback: ApiResultCallback<String?>, isShowLoader: Boolean, id: Int)

    suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean, categoryName: String)

}

class ProductRepositoryImplementation(private val dataSource: ProductsDataSource) : ProductsRepository {

    override suspend fun getAllProducts(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAllProducts()
        }
    }

    override suspend fun getProduct(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProduct(id)
        }
    }

    override suspend fun getAllCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAllCategories()
        }
    }

    override suspend fun getCategories(resultCallback: ApiResultCallback<String?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getCategory(id)
        }
    }

    override suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean, categoryName: String) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductsByCategory(categoryName)
        }
    }

}