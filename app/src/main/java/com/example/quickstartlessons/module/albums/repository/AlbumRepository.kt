package com.example.quickstartlessons.module.albums.repository

import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.albums.data.net.datasource.AlbumDataSource
import retrofit2.Call

interface AlbumRepository {
    fun getAlbumsV1(): Call<AlbumDto>

    suspend fun getAlbumsV2(resultCallback: ApiResultCallback<AlbumDto?>, isShowLoader: Boolean)
}

class AlbumRepositoryImplementation(private val dataSource: AlbumDataSource) : AlbumRepository {

    override fun getAlbumsV1(): Call<AlbumDto> = dataSource.getAlbums()

    override suspend fun getAlbumsV2(resultCallback: ApiResultCallback<AlbumDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAlbumsV2(album_id = 1)
        }
    }
}