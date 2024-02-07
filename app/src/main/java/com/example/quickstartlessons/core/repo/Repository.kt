package com.example.quickstartlessons.core.repo

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.DataSource
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.postsmodel.data.net.responce.PostsDto
import com.example.quickstartlessons.module.product.data.net.response.ProductDto
import com.example.quickstartlessons.module.product.data.net.response.ProductsDto
import com.example.quickstartlessons.core.users.data.net.UsersDto

interface Repository {

    suspend fun getPosts(resultCallback: ApiResultCallback<PostsDto?>, isShowLoader: Boolean)

    suspend fun search(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, name: String)
    suspend fun getUsers(resultCallback: ApiResultCallback<UsersDto?>, isShowLoader: Boolean)

    suspend fun getProductById(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)

    suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)

    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

    suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, category: String)

    suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)
}

class ProductsRepositoryImplementation(private val dataSource: DataSource) : Repository {

    override suspend fun getPosts(resultCallback: ApiResultCallback<PostsDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader){
            dataSource.getPosts()
        }
    }

    override suspend fun search(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, name: String) {
        getHttpResponse(resultCallback, isShowLoader){
            dataSource.search(name)
        }
    }

    override suspend fun getUsers(resultCallback: ApiResultCallback<UsersDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getUsers()
        }
    }

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