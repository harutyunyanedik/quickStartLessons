package com.example.quickstartlessons.module.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.getApi
import com.example.quickstartlessons.core.getApiCategory
import com.example.quickstartlessons.core.repo.CategoriesRepository
import com.example.quickstartlessons.core.repo.CategoriesRepositoryImplementation
import com.example.quickstartlessons.module.data.ProductDto
import com.example.quickstartlessons.module.data.ProductsDto
import com.example.quickstartlessons.core.repo.ProductsRepository
import com.example.quickstartlessons.core.repo.ProductsRepositoryImplementation
import kotlinx.coroutines.launch

class HomeMainTabViewModel : ViewModel() {
    private val repo: ProductsRepository = ProductsRepositoryImplementation(getApi())


    private val _productLiveData: MutableLiveData<List<ProductDto>?> = MutableLiveData()
    val productLiveData: LiveData<List<ProductDto>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    private val repo1: CategoriesRepository = CategoriesRepositoryImplementation(getApiCategory())

    private val _categoryLiveDataCategory: MutableLiveData<List<String>?> = MutableLiveData()
    val categoryLiveDataCategory: LiveData<List<String>?>
        get() = _categoryLiveDataCategory

    private val _categoryErrorLiveDataCategory: MutableLiveData<String?> = MutableLiveData()
    val categoryErrorLiveData: LiveData<String?>
        get() = _categoryErrorLiveDataCategory
    fun getProducts(isShowLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getProductsV2((object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = response?.products
                }
            }), isShowLoader)
        }
    }

    fun getCategories(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo1.getCategories(object :ApiResultCallback<List<String>?> {
                override fun onSuccess(response:List<String>?) {
                    _categoryLiveDataCategory.value = response

                }
            }, isShoLoader)
        }

    }
}