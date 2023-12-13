package com.example.quickstartlessons.homwork.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.retrofit
import com.example.quickstartlessons.homwork.data.Photo
import com.example.quickstartlessons.homwork.data.PhotoDataSource
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import retrofit2.Call

interface PhotoRepository {
    fun getPhoto(): Call<List<Photo>>
    suspend fun getPhotos(resultCallback: ApiResultCallback<List<Photo>>, isShowLoader: Boolean)
}
class PhotoRepositoryImplementation(private val dataSours: PhotoDataSource):PhotoRepository{
    override fun getPhoto(): Call<List<Photo>> = dataSours.getPhoto()

    override suspend fun getPhotos(resultCallback: ApiResultCallback<List<Photo>>, isShowLoader: Boolean){
        dataSours.getPhotos(1)
    }


}