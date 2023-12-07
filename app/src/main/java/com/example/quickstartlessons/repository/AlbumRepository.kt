package com.example.quickstartlessons.repository

import com.example.quickstartlessons.data.net.api.ApiResultCallback
import com.example.quickstartlessons.data.net.api.getApi
import com.example.quickstartlessons.data.net.api.getHttpResponse
import com.example.quickstartlessons.data.net.model.AlbumDto
import retrofit2.Call

interface AlbumRepository {

    fun getAlbum(): Call<AlbumDto>

    suspend fun getAlbumV2(resultCallback: ApiResultCallback<AlbumDto?>, isShowLoader: Boolean)
}

class AlbumRepositoryImpl : AlbumRepository {

    override fun getAlbum(): Call<AlbumDto> = getApi().getAlbums()

    override suspend fun getAlbumV2(resultCallback: ApiResultCallback<AlbumDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            getApi().getAlbumsV2()
        }
    }
}
