package com.example.quickstartlessons.module.Users.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.room.dao.net.ApiResultCallback
import com.example.quickstartlessons.core.room.dao.net.repo.repository.ProductsRepository
import com.example.quickstartlessons.module.Users.data.response.UserDto
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.Users.data.response.UsersDto
import kotlinx.coroutines.launch

class UsersViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _usersLiveData: MutableLiveData<UsersDto?> = MutableLiveData()
    val usersLiveData: LiveData<UsersDto?>
        get() = _usersLiveData

    private val _usersErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val usersErrorLiveData: LiveData<String>
        get() = _usersErrorLiveData

    fun getAllUsers(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAllUsers(object : ApiResultCallback<UsersDto?> {
                override fun onSuccess(response: UsersDto?) {
                    _usersLiveData.value = response
                }

                override fun onError(): Boolean {
                    _usersErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader)
        }
    }
    private val _userLiveData: MutableLiveData<UserDto> = MutableLiveData()
    val userLiveData: MutableLiveData<UserDto>
        get() = _userLiveData

}