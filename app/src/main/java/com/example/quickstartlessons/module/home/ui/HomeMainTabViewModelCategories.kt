package com.example.quickstartlessons.module.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApiCategory
import com.example.quickstartlessons.core.net.repository.CategoriesRepository
import com.example.quickstartlessons.core.net.repository.CategoryRepositoryImplementation
import kotlinx.coroutines.launch

class HomeMainTabViewModelCategories:ViewModel() { // todo es viewModel e jnji mejine tar HomeMainTabViewModel
    private val repository:     CategoriesRepository = CategoryRepositoryImplementation(getApiCategory())

    private val _productLiveDataCategory: MutableLiveData   <List<String>?> = MutableLiveData()
    val productLiveDataCategory: LiveData<List<String>?>
        get() = _productLiveDataCategory

    private val _productErrorLiveDataCategory: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveDataCategory

    fun getCategories(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repository.getCategories(object :ApiResultCallback<List<String>?> {
                override fun onSuccess(response:List<String>?) {
                    _productLiveDataCategory.value = response

                }
            }, isShoLoader)

        }
    }
}