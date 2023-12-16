package com.example.quickstartlessons.module.albums.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.module.albums.data.model.response.Photos
import com.example.quickstartlessons.module.albums.repository.PhotosRepository
import com.example.quickstartlessons.module.albums.repository.PhotosRepositoryImplementation
import kotlinx.coroutines.launch

class PhotoViewModel : ViewModel() {

    private val repo: PhotosRepository = PhotosRepositoryImplementation(getApi())

    private val _photoLiveData: MutableLiveData<Photos?> = MutableLiveData()
    val albumLiveData: MutableLiveData<Photos?>
        get() = _photoLiveData

    private val _albumErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val albumErrorLiveData: LiveData<String?>
        get() = _albumErrorLiveData

    fun getAlbums(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAlbumsV2(object : ApiResultCallback<Photos?> {
                override fun onSuccess(response: Photos?) {
                    _photoLiveData.value = response
                }
            }, isShoLoader)
        }
    }
}