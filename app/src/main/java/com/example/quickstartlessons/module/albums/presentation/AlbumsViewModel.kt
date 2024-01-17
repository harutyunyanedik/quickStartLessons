package com.example.quickstartlessons.module.albums.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.getApi
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import com.example.quickstartlessons.module.albums.repository.AlbumRepository
import com.example.quickstartlessons.module.albums.repository.AlbumRepositoryImplementation
import kotlinx.coroutines.launch

class AlbumsViewModel : ViewModel() {

    private val repo: AlbumRepository = AlbumRepositoryImplementation(getApi())


    private val _albumLiveData: MutableLiveData<List<AlbumDto>?> = MutableLiveData()
    val albumLiveData: LiveData<List<AlbumDto>?>
        get() = _albumLiveData

    private val _albumErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val albumErrorLiveData: LiveData<String?>
        get() = _albumErrorLiveData

    fun getAlbums(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAlbumsV2(object : ApiResultCallback<List<AlbumDto>?> {
                override fun onSuccess(response: List<AlbumDto>?) {
                    _albumLiveData.value = response
                }
            }, isShoLoader)
        }
    }
}