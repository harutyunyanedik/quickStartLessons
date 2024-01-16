package com.example.quickstartlessons.core.net.products.repo

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.products.datasource.ProductDataSource
import com.example.quickstartlessons.core.net.products.dto.ProductsDto
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.core.net.products.dto.Products
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Call


interface ProductsRepository {
    fun getProductsV1(): Call<Products>

    suspend fun getProductsV2(resultCallback: ApiResultCallback<Products?>, isShowLoader: Boolean)

    fun getProductV1(id: Int): Call<ProductsDto>

    suspend fun getProductV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int)
}

class ProductsRepositoryImplementation(private val dataSource: ProductDataSource) : ProductsRepository {

    override fun getProductsV1(): Call<Products> = dataSource.getProducts()

    override suspend fun getProductsV2(resultCallback: ApiResultCallback<Products?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductsV2()
        }
    }

    override fun getProductV1(id: Int): Call<ProductsDto> = dataSource.getProduct(id)

    override suspend fun getProductV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProductV2(id)
        }
    }


}