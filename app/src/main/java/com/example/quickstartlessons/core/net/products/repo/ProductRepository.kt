package com.example.quickstartlessons.core.net.products.repo

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.products.datasource.ProductDataSource
import com.example.quickstartlessons.core.net.products.dto.ProductsDto
import com.example.quickstartlessons.core.net.getHttpResponse

interface ProductRepository {
    suspend fun getAlbumsV2(resultCallback: ApiResultCallback<List<ProductsDto>?>, isShowLoader: Boolean)

    suspend fun getAlbumV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int)
}

class ProductRepositoryImplementation (private val dataSource: ProductDataSource): ProductRepository {
    override suspend fun getAlbumsV2(resultCallback: ApiResultCallback<List<ProductsDto>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAlbumsV2()
        }
    }

    override suspend fun getAlbumV2(resultCallback: ApiResultCallback<ProductsDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAlbumV2(id)
        }
    }
}