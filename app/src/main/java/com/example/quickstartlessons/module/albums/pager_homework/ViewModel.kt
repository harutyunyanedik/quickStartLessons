package com.example.quickstartlessons.module.albums.pager_homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.module.albums.repository.AlbumRepository
import com.example.quickstartlessons.module.albums.repository.AlbumRepositoryImplementation
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    private val repo: AlbumRepository = AlbumRepositoryImplementation(getApi())

    private val _liveData: MutableLiveData<String?> = MutableLiveData()
    val liveData: LiveData<String?>
        get() = _liveData

    private val _errorLiveData: MutableLiveData<String?> = MutableLiveData()
    val errorLiveData: LiveData<String?>
        get() = _errorLiveData

    fun setValueToLiveData(test:String){
        _liveData.value = test
    }
}