package com.example.quickstartlessons.module.albums.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.module.albums.pager_homework.PagerModel
import com.example.quickstartlessons.module.albums.repository.AlbumRepository
import com.example.quickstartlessons.module.albums.repository.AlbumRepositoryImplementation
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel() {

    private val repo: AlbumRepository = AlbumRepositoryImplementation(getApi())

    private val _liveData: MutableLiveData<PagerModel?> = MutableLiveData()
    val liveData: LiveData<PagerModel?>
        get() = _liveData

    private val _errorLiveData: MutableLiveData<String?> = MutableLiveData()
    val errorLiveData: LiveData<String?>
        get() = _errorLiveData

//    fun getAlbums(isShoLoader: Boolean = true) {
//        viewModelScope.launch {
//            repo.getAlbums(object : ApiResultCallback<PagerModel?> {
//                override fun onSuccess(response: PagerModel?) {
//                    _liveData.value = response
//                }
//            }, isShoLoader)
//        }
//    }
}