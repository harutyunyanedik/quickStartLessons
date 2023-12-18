package com.example.quickstartlessons.homework

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getHttpResponse

interface Repository {
    suspend fun getPhoto2(resultCallback: ApiResultCallback<List<Photo>?>, isShowLoader: Boolean)
}

class PhotoRepository(private val photoDataSource: PhotoDataSource) : Repository {
    override suspend fun getPhoto2(resultCallback: ApiResultCallback<List<Photo>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            photoDataSource.getPhotos()
        }
    }
}