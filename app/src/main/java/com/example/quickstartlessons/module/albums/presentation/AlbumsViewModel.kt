package com.example.quickstartlessons.module.albums.presentation

import androidx.lifecycle.ViewModel

class AlbumsViewModel : ViewModel() {

//    private val repo: AlbumRepository = AlbumRepositoryImplementation(getApi())
//
//    private val _albumLiveData: MutableLiveData<List<AlbumDto>?> = MutableLiveData()
//    val albumLiveData: LiveData<List<AlbumDto>?>
//        get() = _albumLiveData
//
//    private val _albumErrorLiveData: MutableLiveData<String?> = MutableLiveData()
//    val albumErrorLiveData: LiveData<String?>
//        get() = _albumErrorLiveData
//
//    fun getAlbums(isShoLoader: Boolean = true) {
//        viewModelScope.launch {
//            repo.getAlbumsV2(object : ApiResultCallback<List<AlbumDto>?> {
//                override fun onSuccess(response: List<AlbumDto>?) {
//                    _albumLiveData.value = response
//                }
//            }, isShoLoader)
//        }
//    }
}