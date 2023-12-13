package com.example.quickstartlessons.homwork.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.homwork.api.getApiPhoto
import com.example.quickstartlessons.homwork.data.Photo
import com.example.quickstartlessons.homwork.repository.PhotoRepository
import com.example.quickstartlessons.homwork.repository.PhotoRepositoryImplementation
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import kotlinx.coroutines.launch


class ViewModelPhoto : ViewModel() {
    private val repository: PhotoRepository = PhotoRepositoryImplementation(getApiPhoto())

    private val _photoLiveData: MutableLiveData<List<Photo>?> = MutableLiveData()
    val photoLiveData: LiveData<List<Photo>?>
        get() = _photoLiveData

    private val _photoErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val photoErrorLiveData: LiveData<String?>
        get() = _photoErrorLiveData

    fun getPhotos(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            viewModelScope.launch {
                repository.getPhotos(object : ApiResultCallback<List<Photo>> {
                    override fun onSuccess(response: List<Photo>) {
                        _photoLiveData.value = response
                    }
                }, isShoLoader)
            }
        }
    }

}