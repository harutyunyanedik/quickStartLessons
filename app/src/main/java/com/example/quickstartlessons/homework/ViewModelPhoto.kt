package com.example.quickstartlessons.homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import kotlinx.coroutines.launch

class ViewModelPhoto : ViewModel() {
    private val repository: Repository = PhotoRepository(apiPhoto)

    private val _photoLiveData: MutableLiveData<List<Photo>?> = MutableLiveData()
    val photoLiveData: LiveData<List<Photo>?>
        get() = _photoLiveData

    private val _errorPhotoLiveData: MutableLiveData<String> = MutableLiveData()
    val errorPhotoLiveData: LiveData<String>
        get() = _errorPhotoLiveData

    fun getPhoto(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repository.getPhoto2(object: ApiResultCallback<List<Photo>?>{
                override fun onSuccess(response: List<Photo>?) {
                    _photoLiveData.value= response
                }

            },isShoLoader)

        }
    }
}

