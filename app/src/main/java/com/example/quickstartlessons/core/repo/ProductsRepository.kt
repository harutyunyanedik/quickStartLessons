package com.example.quickstartlessons.core.repo

import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.module.products.data.ProductDto
import com.example.quickstartlessons.core.getHttpResponse
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.module.account.users.data.UsersDto
import com.example.quickstartlessons.module.posts.data.PostDto
import com.example.quickstartlessons.module.products.data.ProductsDto
import retrofit2.Call


interface ProductsRepository {

    suspend fun getPosts(resultCallback: ApiResultCallback<PostDto?>, isShowLoader: Boolean)

    suspend fun getUsers(resultCallback: ApiResultCallback<UsersDto?>, isShowLoader: Boolean)
    fun getProductsV1(): Call<ProductsDto>

    suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)

    fun getProductV1(id: Int): Call<ProductDto>

    suspend fun getProductById(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)

    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

    suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, category: String)

    suspend fun search(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, name: String)
}

class ProductsRepositoryImplementation(private val productDataSource: ProductDataSource) : ProductsRepository {
    override suspend fun getPosts(resultCallback: ApiResultCallback<PostDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.getPosts()
        }
    }

    override suspend fun getUsers(resultCallback: ApiResultCallback<UsersDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.getUsers()
        }
    }

    override fun getProductsV1(): Call<ProductsDto> = productDataSource.getProducts()

    override suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.getProductsV2()
        }
    }

    override fun getProductV1(id: Int): Call<ProductDto> = productDataSource.getProduct(id)

    override suspend fun getProductById(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.getProductById(id)
        }

    }

    override suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.getCategories()
        }
    }

    override suspend fun getProductsByCategory(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, category: String) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.getProductsByCategory(category)
        }
    }

    override suspend fun search(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, name: String) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.search(name)
        }
    }
}


