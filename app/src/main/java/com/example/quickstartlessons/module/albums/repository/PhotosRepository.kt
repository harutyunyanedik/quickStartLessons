package com.example.quickstartlessons.module.albums.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.albums.data.model.response.PhotoDto
import com.example.quickstartlessons.module.albums.data.model.response.Photos
import com.example.quickstartlessons.module.albums.data.net.datasource.PhotosDataSource
import retrofit2.Call

interface PhotosRepository {
    fun getAlbumsV1(): Call<PhotoDto>

    suspend fun getAlbumsV2(resultCallback: ApiResultCallback<Photos?>, isShowLoader: Boolean)
}

class PhotosRepositoryImplementation(private val dataSource: PhotosDataSource) : PhotosRepository {

    override fun getAlbumsV1(): Call<PhotoDto> = dataSource.getPhoto()

    override suspend fun getAlbumsV2(resultCallback: ApiResultCallback<Photos?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAlbumsV2()
        }
    }
}