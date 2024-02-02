package com.example.quickstartlessons.core.net.repo.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.core.net.repo.datasource.ProductsDataSource
import com.example.quickstartlessons.module.account.responceModel.UsersDto
import com.example.quickstartlessons.module.account.responceModel.UsersModel
import com.example.quickstartlessons.module.settings.model.products.ProductsDto
import com.example.quickstartlessons.module.settings.model.products.ProductsModel

interface ProductsRepository {

    suspend fun getAllProducts(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean)

    suspend fun getProductById(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int)

    suspend fun getAllCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

    suspend fun getCategories(resultCallback: ApiResultCallback<String?>, isShowLoader: Boolean, id: Int)

    suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean, categoryName: String)

    suspend fun getAllUsers(resultCallback: ApiResultCallback<UsersModel?>, isShowLoader: Boolean)

    suspend fun getUser(resultCallback: ApiResultCallback <UsersDto?>, isShowLoader: Boolean,id:Int)

}

class ProductRepositoryImplementation(private val dataSource: ProductsDataSource) : ProductsRepository {

    override suspend fun getAllProducts(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAllProducts()
        }
    }

    override suspend fun getProductById(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductById(id)
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

    override suspend fun getAllUsers(resultCallback: ApiResultCallback<UsersModel?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource. getAllUsers()
        }
    }

    override suspend fun getUser(resultCallback: ApiResultCallback<UsersDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getUser(id)
        }
    }

}