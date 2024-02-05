package com.example.quickstartlessons.module.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.repo.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.posts.data.PostDto
import kotlinx.coroutines.launch

class PostsViewModel(private val repository: ProductsRepository) : BaseObservableViewModel() {
    private val _postsLiveData = MutableLiveData<List<PostDto?>>()
    val postsLiveData: LiveData<List<PostDto?>>
        get() = _postsLiveData

    private val _postsErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val postsErrorLiveData: LiveData<String?>
        get() = _postsErrorLiveData

    fun getProducts(isShowLoader: Boolean = true) {
        viewModelScope.launch {
            repository.getPosts((object : ApiResultCallback<PostDto?> {
                override fun onSuccess(response: PostDto?) {
                    _postsLiveData.value = listOf(response)

                }

                override fun onError(): Boolean {
                    _postsErrorLiveData.value = "Error data"
                    return true
                }
            }), isShowLoader)
        }
    }
}