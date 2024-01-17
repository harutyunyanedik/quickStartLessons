package com.example.quickstartlessons.module.albums.repository

import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.net.ProductDataSource
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Call

interface AlbumRepository {
    fun getAlbumsV1(): Call<List<AlbumDto>>

    suspend fun getAlbumsV2(resultCallback: ApiResultCallback<List<AlbumDto>?>, isShowLoader: Boolean)

    fun getAlbumV1(id: Int): Call<AlbumDto>

    suspend fun getAlbumV2(resultCallback: ApiResultCallback<AlbumDto?>, isShowLoader: Boolean, id: Int)
}

class AlbumRepositoryImplementation(private val dataSource: ProductDataSource) : AlbumRepository {
    override fun getAlbumsV1(): Call<List<AlbumDto>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbumsV2(resultCallback: ApiResultCallback<List<AlbumDto>?>, isShowLoader: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getAlbumV1(id: Int): Call<AlbumDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbumV2(resultCallback: ApiResultCallback<AlbumDto?>, isShowLoader: Boolean, id: Int) {
        TODO("Not yet implemented")
    }


}