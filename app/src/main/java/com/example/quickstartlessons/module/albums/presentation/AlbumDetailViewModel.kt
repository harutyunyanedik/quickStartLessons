package com.example.quickstartlessons.module.albums.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import com.example.quickstartlessons.module.albums.repository.AlbumRepository
import com.example.quickstartlessons.module.albums.repository.AlbumRepositoryImplementation
import kotlinx.coroutines.launch

class AlbumDetailViewModel: ViewModel() {

    private val repo: AlbumRepository = AlbumRepositoryImplementation(getApi())

    private val _albumLiveData: MutableLiveData<AlbumDto?> = MutableLiveData()
    val albumLiveData: LiveData<AlbumDto?>
        get() = _albumLiveData

    private val _albumErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val albumErrorLiveData: LiveData<String?>
        get() = _albumErrorLiveData

    fun getAlbums(isShoLoader: Boolean = true, id: Int) {
        viewModelScope.launch {
            repo.getAlbumV2(object : ApiResultCallback<AlbumDto?> {
                override fun onSuccess(response: AlbumDto?) {
                    _albumLiveData.value = response
                }
            }, isShoLoader, id)
        }
    }
}