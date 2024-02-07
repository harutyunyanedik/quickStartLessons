package com.example.quickstartlessons.module.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.repo.Repository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.postsmodel.data.net.responce.PostsDto
import kotlinx.coroutines.launch

class PostsViewModel(private val repo: Repository) : BaseObservableViewModel() {

    private val _postsLiveData = MutableLiveData<PostsDto?>()
    val postsLiveData : LiveData<PostsDto?>
        get() = _postsLiveData

    private val _postsErrorLiveData = MutableLiveData<String?>()
    val postsErrorLiveData: LiveData<String?>
        get() = _postsErrorLiveData

    fun getPosts(isShowLoader: Boolean = false) {
        viewModelScope.launch {
            repo.getPosts((object : ApiResultCallback<PostsDto?> {
                override fun onSuccess(response: PostsDto?) {
                    _postsLiveData.value = response
                }

                override fun onError(): Boolean {
                    _postsErrorLiveData.value = "The request failed"
                    return true
                }
            }), isShowLoader)
        }
    }
}