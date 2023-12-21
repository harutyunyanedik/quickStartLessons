package com.example.quickstartlessons.module.albums.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse
import com.example.quickstartlessons.module.albums.data.model.response.PhotoDto
import com.example.quickstartlessons.module.albums.data.net.datasource.PhotosDataSource
import retrofit2.Call

interface PhotosRepository {
    fun getAlbumsV1(): Call<List<PhotoDto>>

    suspend fun getAlbumsV2(resultCallback: ApiResultCallback<List<PhotoDto>?>, isShowLoader: Boolean)

    fun getAlbumV1(id: Int): Call<PhotoDto>

    suspend fun getAlbumV2(resultCallback: ApiResultCallback<PhotoDto?>, isShowLoader: Boolean, id: Int)
}

class PhotosRepositoryImplementation(private val dataSource: PhotosDataSource) : PhotosRepository{

    override fun getAlbumsV1(): Call<List<PhotoDto>> = dataSource.getAlbums()

    override suspend fun getAlbumsV2(resultCallback: ApiResultCallback<List<PhotoDto>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAlbumsV2()
        }
    }

    override fun getAlbumV1(id: Int): Call<PhotoDto> = dataSource.getAlbum(id)

    override suspend fun getAlbumV2(resultCallback: ApiResultCallback<PhotoDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getAlbumV2(id)
        }
    }
}