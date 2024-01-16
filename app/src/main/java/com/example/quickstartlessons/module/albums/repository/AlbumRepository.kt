package com.example.quickstartlessons.module.albums.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.core.net.products.datasource.ProductDataSource
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Call

interface AlbumRepository {
    fun getAlbumsV1(): Call<List<AlbumDto>>

    suspend fun getAlbumsV2(resultCallback: ApiResultCallback<List<AlbumDto>?>, isShowLoader: Boolean)

    fun getAlbumV1(id: Int): Call<AlbumDto>

    suspend fun getAlbumV2(resultCallback: ApiResultCallback<AlbumDto?>, isShowLoader: Boolean, id: Int)
}

class AlbumRepositoryImplementation(private val dataSource: ProductDataSource) : AlbumRepository {

    override fun getAlbumsV1(): Call<List<AlbumDto>> = dataSource.getAlbums()

    override suspend fun getAlbumsV2(resultCallback: ApiResultCallback<List<AlbumDto>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAlbumsV2()
        }
    }

    override fun getAlbumV1(id: Int): Call<AlbumDto> = dataSource.getAlbum(id)

    override suspend fun getAlbumV2(resultCallback: ApiResultCallback<AlbumDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAlbumV2(id)
        }
    }
}