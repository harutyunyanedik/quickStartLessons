package com.example.quickstartlessons.tablayout

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import com.example.quickstartlessons.module.albums.data.net.datasource.AlbumDataSource
import com.example.quickstartlessons.module.albums.repository.AlbumRepository
import retrofit2.Call

interface ProductRepo {

    suspend fun getProducts(resultCallback: ApiResultCallback<Product?>, isShowLoader: Boolean)
}

class ProductRepositoryImplementation(private val dataSource: ProductDataSource) : ProductRepo {
    override suspend fun getProducts(resultCallback: ApiResultCallback<Product?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback,isShowLoader){
            dataSource.getProduct()
        }
    }


}