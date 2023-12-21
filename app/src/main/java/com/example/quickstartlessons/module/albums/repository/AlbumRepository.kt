package com.example.quickstartlessons.module.albums.repository

import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.albums.data.net.datasource.AlbumDataSource
import com.example.quickstartlessons.module.albums.pager_homework.PagerModel
import retrofit2.Call

interface AlbumRepository {
    suspend fun getAlbums(resultCallback: ApiResultCallback<PagerModel?>, isShowLoader: Boolean)
}

class AlbumRepositoryImplementation(private val dataSource: AlbumDataSource) : AlbumRepository {

    override suspend fun getAlbums(resultCallback: ApiResultCallback<PagerModel?>, isShowLoader: Boolean) {
            dataSource.getAlbums()
    }
}