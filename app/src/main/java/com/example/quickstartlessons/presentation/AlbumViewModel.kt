package com.example.quickstartlessons.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.data.net.api.ApiResultCallback
import com.example.quickstartlessons.data.net.api.getHttpResult
import com.example.quickstartlessons.data.net.model.AlbumDto
import com.example.quickstartlessons.repository.AlbumRepository
import com.example.quickstartlessons.repository.AlbumRepositoryImpl
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel() {

    private val repo: AlbumRepository = AlbumRepositoryImpl()

    private val _albumLiveData: MutableLiveData<AlbumDto?> = MutableLiveData()
    val albumLiveData: LiveData<AlbumDto?>
        get() = _albumLiveData


    fun getAlbum() {
        repo.getAlbum().getHttpResult {
            _albumLiveData.value = it
        }
    }

    fun getAlbumV2() {
        viewModelScope.launch {
            repo.getAlbumV2(object : ApiResultCallback<AlbumDto?> {
                override fun onSuccess(response: AlbumDto?) {
                    _albumLiveData.value = response
                }

            }, isShowLoader = true)
        }
    }

}