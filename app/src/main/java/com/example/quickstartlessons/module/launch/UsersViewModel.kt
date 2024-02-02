package com.example.quickstartlessons.module.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.repo.Repository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.users.data.net.UsersDto
import kotlinx.coroutines.launch

class UsersViewModel(private val repo: Repository) : BaseObservableViewModel() {

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