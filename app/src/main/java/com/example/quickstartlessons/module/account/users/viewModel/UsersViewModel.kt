package com.example.quickstartlessons.module.account.users.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.repo.ProductsRepository
import com.example.quickstartlessons.module.account.users.data.UsersDto
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import kotlinx.coroutines.launch

class UsersViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _usersLiveData = MutableLiveData<UsersDto?>()
    val usersLiveData: LiveData<UsersDto?>
        get() = _usersLiveData

    private val _usersErrorLiveData = MutableLiveData<String?>()
    val usersErrorLiveData: LiveData<String?>
        get() = _usersErrorLiveData

    fun getUsers(isShowLoader: Boolean = false) {
        viewModelScope.launch {
            repo.getUsers((object : ApiResultCallback<UsersDto?> {
                override fun onSuccess(response: UsersDto?) {
                    _usersLiveData.value = response
                }

                override fun onError(): Boolean {
                    _usersErrorLiveData.value = "The request failed"
                    return true
                }
            }), isShowLoader)
        }
    }
}