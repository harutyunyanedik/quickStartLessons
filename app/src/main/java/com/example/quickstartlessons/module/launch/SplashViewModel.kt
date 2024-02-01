package com.example.quickstartlessons.module.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.repository.Repository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.product.data.model.response.ProductDto
import com.example.quickstartlessons.module.user.data.response.UserDto
import com.example.quickstartlessons.module.user.data.response.UsersDto
import kotlinx.coroutines.launch

class SplashViewModel  (private val repository: Repository) : BaseObservableViewModel() {
    private val _userLiveData: MutableLiveData<UserDto?> = MutableLiveData()
    val userLiveData: LiveData<UserDto?>
        get() = _userLiveData
    private val _userErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val userErrorLiveData: LiveData<String?>
        get() =_userErrorLiveData

    fun getUser(isShowLoader: Boolean = true,id:Int){
        viewModelScope.launch {
            repository.getUser(object :ApiResultCallback<UserDto?>{
                override fun onSuccess(response: UserDto?) {
                    _userLiveData.value=response
                }

                override fun onError(): Boolean {
                    _userErrorLiveData.value="Error data"
                    return true
                }

            }, isShowLoader,id)
        }
    }
    private val _usersLiveData: MutableLiveData<List<UserDto>?> = MutableLiveData()
    val usersLiveData: LiveData<List<UserDto>?>
        get() = _usersLiveData
    private val _usersErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val usersErrorLiveData: LiveData<String?>
        get() =_usersErrorLiveData


     fun getUsers(isShowLoader: Boolean = true){
         viewModelScope.launch {
             repository.getUsers(object :ApiResultCallback<UsersDto?> {
                 override fun onSuccess(response: UsersDto?) {
                    _usersLiveData.value=response?.users
                 }

                 override fun onError(): Boolean {
                     _usersErrorLiveData.value="Error data"
                     return true
                 }

             },isShowLoader)
             }
         }
     }