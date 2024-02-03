package com.example.quickstartlessons.core.room.dao.net.repo.repository

import com.example.quickstartlessons.core.room.dao.net.ApiResultCallback
import com.example.quickstartlessons.core.room.dao.net.getHttpResponse
import com.example.quickstartlessons.core.room.dao.net.repo.datasource.ProductsDataSource
import com.example.quickstartlessons.module.Users.data.response.UserDto
import com.example.quickstartlessons.module.Users.data.response.UsersDto
import com.example.quickstartlessons.module.settings.model.products.ProductsDto
import com.example.quickstartlessons.module.settings.model.products.ProductsModel

interface ProductsRepository {

    suspend fun getAllProducts(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean)

    suspend fun getProductById(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int)

    suspend fun getAllCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

    suspend fun getCategories(resultCallback: ApiResultCallback<String?>, isShowLoader: Boolean, id: Int)

    suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsModel?>, isShowLoader: Boolean, categoryName: String)

    suspend fun getAllUsers(resultCallback: ApiResultCallback<UsersDto?>, isShowLoader: Boolean)

    suspend fun getUser(resultCallback: ApiResultCallback<UserDto?>, isShowLoader: Boolean, id:Int)

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

    override suspend fun getAllUsers(resultCallback: ApiResultCallback<UsersDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource. getAllUsers()
        }
    }

    override suspend fun getUser(resultCallback: ApiResultCallback<UserDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getUser(id)
        }
    }

}