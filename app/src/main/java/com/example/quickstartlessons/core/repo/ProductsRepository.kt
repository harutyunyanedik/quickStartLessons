package com.example.quickstartlessons.core.repo

import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.module.products.data.ProductDto
import com.example.quickstartlessons.core.getHttpResponse
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.module.products.data.ProductsDto
import retrofit2.Call


interface ProductsRepository {
    fun getProductsV1(): Call<ProductsDto>

    suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)

    fun getProductV1(id: Int): Call<ProductDto>

    suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int)

    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)
}

class ProductsRepositoryImplementation(private val productDataSource: ProductDataSource) : ProductsRepository {
    override fun getProductsV1(): Call<ProductsDto> = productDataSource.getProducts()

    override suspend fun getProductsV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.getProductsV2()
        }
    }

    override fun getProductV1(id: Int): Call<ProductDto> = productDataSource.getProduct(id)

    override suspend fun getProductV2(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            productDataSource.getProductV2(id)
        }

    }

    override suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback,isShowLoader){
            productDataSource.getCategories()
        }
    }

}


