package com.example.quickstartlessons.module.home.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getProduct
import com.example.quickstartlessons.core.net.repo.repository.ProductRepositoryImplementation
import com.example.quickstartlessons.core.net.repo.repository.ProductsRepository
import kotlinx.coroutines.launch

class CategoriesViewModel: ViewModel() { // todo jnji tar HomeMainTabViewModel i mej

    private val repo: ProductsRepository = ProductRepositoryImplementation(getProduct())

    private val _categoriesLiveData: MutableLiveData<List<String>?> = MutableLiveData()
    val categoriesLiveData: LiveData<List<String>?>
        get() = _categoriesLiveData

    private val _categoriesErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val categoriesErrorLiveData: LiveData<String?>
        get() = _categoriesErrorLiveData

    fun getCategories(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAllCategories(object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response:List<String>?) {
                   _categoriesLiveData.value = response
                }
            }, false)
        }
    }
}