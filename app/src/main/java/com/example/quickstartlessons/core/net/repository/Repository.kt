package com.example.quickstartlessons.core.net.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.module.product.data.model.response.ProductsDto
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.product.data.model.response.ProductDto


interface Repository {
    suspend fun getProducts(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean)
    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)
    suspend fun getProductByCategory(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id:String)
    suspend fun getProductById(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id:Int)
}

class RepositoryImplementation(private val dataSource: ProductDataSource) : Repository {

    override suspend fun getProducts(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getProduct()
        }
    }

    override suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback,isShowLoader) {
            dataSource.getCategories()
        }
    }
    override suspend fun getProductByCategory(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: String) {
        getHttpResponse(resultCallback,isShowLoader){
         dataSource.getProductByCategory(id)
        }
    }

    override suspend fun getProductById(resultCallback: ApiResultCallback<ProductDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback,isShowLoader){
            dataSource.getProductById(id)
        }
    }
}
