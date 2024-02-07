package com.example.quickstartlessons.module.posts.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.room.dao.net.ApiResultCallback
import com.example.quickstartlessons.core.room.dao.net.repo.repository.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.posts.data.response.PostsDto
import kotlinx.coroutines.launch

class PostsViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _postsLiveData: MutableLiveData<PostsDto?> = MutableLiveData()
    val postsLiveData: LiveData<PostsDto?>
        get() = _postsLiveData

    private val _postsErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val postsErrorLiveData: LiveData<String>
        get() = _postsErrorLiveData

    fun getPosts(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAllPosts(object : ApiResultCallback<PostsDto?> {
                override fun onSuccess(response: PostsDto?) {
                    _postsLiveData.value = response
                }

                override fun onError(): Boolean {
                    _postsErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader)
        }
    }
}
