package com.example.quickstartlessons.module.home.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.repo.repository.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.account.responceModel.UsersDto
import com.example.quickstartlessons.module.account.responceModel.UsersModel
import kotlinx.coroutines.launch

class UsersViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _usersLiveData: MutableLiveData<UsersModel?> = MutableLiveData()
    val usersLiveData: LiveData<UsersModel?>
        get() = _usersLiveData

    private val _usersErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val usersErrorLiveData: LiveData<String>
        get() = _usersErrorLiveData

    fun getAllUsers(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAllUsers(object : ApiResultCallback<UsersModel?> {
                override fun onSuccess(response: UsersModel?) {
                    _usersLiveData.value = response
                }

                override fun onError(): Boolean {
                    _usersErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader)
        }
    }

    private val _userLiveData: MutableLiveData<UsersDto?> = MutableLiveData()
    val userLiveData: LiveData <UsersDto?>
        get() = _userLiveData

    private val _userErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val userErrorLiveData: LiveData<String>
        get() = _userErrorLiveData

    fun getUserById(isShoLoader: Boolean = true, id:Int) {
        viewModelScope.launch {
            repo.getUser(object : ApiResultCallback<UsersDto?> {
                override fun onSuccess(response: UsersDto?) {
                    _userLiveData.value = response
                }

                override fun onError(): Boolean {
                    _userErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader,id)
        }
    }
}