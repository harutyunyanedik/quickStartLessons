package com.example.quickstartlessons.module.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.getApiCategory
import com.example.quickstartlessons.core.repo.CategoriesRepository
import com.example.quickstartlessons.core.repo.CategoriesRepositoryImplementation
import kotlinx.coroutines.launch

class CategoriesViewModel:ViewModel() {
    private val repo: CategoriesRepository = CategoriesRepositoryImplementation(getApiCategory())

    private val _categoryLiveDataCategory: MutableLiveData<List<String>?> = MutableLiveData()
    val categoryLiveDataCategory: LiveData<List<String>?>
        get() = _categoryLiveDataCategory

    private val _categoryErrorLiveDataCategory: MutableLiveData<String?> = MutableLiveData()
    val categoryErrorLiveData: LiveData<String?>
        get() = _categoryErrorLiveDataCategory



    fun getCategories(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getCategories(object :ApiResultCallback<List<String>?> {
                override fun onSuccess(response:List<String>?) {
                    _categoryLiveDataCategory.value = response

                }
            }, isShoLoader)
        }

    }
}