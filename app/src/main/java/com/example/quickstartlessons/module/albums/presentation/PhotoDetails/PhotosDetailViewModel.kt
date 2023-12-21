package com.example.quickstartlessons.module.albums.presentation.PhotoDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.module.albums.data.model.response.PhotoDto
import com.example.quickstartlessons.module.albums.repository.PhotosRepository
import com.example.quickstartlessons.module.albums.repository.PhotosRepositoryImplementation
import kotlinx.coroutines.launch

class PhotosDetailViewModel: ViewModel() {

    private val repo: PhotosRepository = PhotosRepositoryImplementation(getApi())

    private val _albumLiveData: MutableLiveData<PhotoDto?> = MutableLiveData()
    val albumLiveData: LiveData<PhotoDto?>
        get() = _albumLiveData

    private val _albumErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val albumErrorLiveData: LiveData<String?>
        get() = _albumErrorLiveData

    fun getAlbums(isShoLoader: Boolean = true, id: Int) {
        viewModelScope.launch {
            repo.getAlbumV2(object : ApiResultCallback<PhotoDto?> {
                override fun onSuccess(response: PhotoDto?) {
                    _albumLiveData.value = response
                }
            }, isShoLoader, id)
        }
    }
}