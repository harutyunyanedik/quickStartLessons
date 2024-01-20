package com.example.quickstartlessons.module.home.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.getApi
import com.example.quickstartlessons.module.products.data.ProductDto
import com.example.quickstartlessons.module.products.data.ProductsDto
import com.example.quickstartlessons.core.repo.ProductsRepository
import com.example.quickstartlessons.core.repo.ProductsRepositoryImplementation
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeMainTabViewModel : ViewModel() {
    private val repo: ProductsRepository = ProductsRepositoryImplementation(getApi())


    private val _productLiveData: MutableLiveData<List<ProductDto>?> = MutableLiveData()
    val productLiveData: LiveData<List<ProductDto>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    private val _categoryLiveDataCategory: MutableLiveData<List<String>?> = MutableLiveData()
    val categoryLiveDataCategory: LiveData<List<String>?>
        get() = _categoryLiveDataCategory

    private val _categoryErrorLiveDataCategory: MutableLiveData<String?> = MutableLiveData()
    val categoryErrorLiveData: LiveData<String?>
        get() = _categoryErrorLiveDataCategory

    private val _productsByCategoryLiveData: MutableLiveData<ProductsDto> = MutableLiveData()
    val productsByCategoryLiveData: LiveData<ProductsDto>
        get() = _productsByCategoryLiveData

    private val _productsByCategoryErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productsByCategoryErrorLiveData: LiveData<String?>
        get() = _productsByCategoryErrorLiveData


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
            repo.getCategories(object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response: List<String>?) {
                    _categoryLiveDataCategory.value = response

                }
            }, isShoLoader)
        }

    }

    fun getProductsByCategory(isShowLoader: Boolean = true, category: String) {
        viewModelScope.launch {
            repo.getProductsByCategory((object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = response?.products
                }
            }), isShowLoader, category)
        }
    }

}