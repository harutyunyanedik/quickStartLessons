package com.example.quickstartlessons.module.home.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.repo.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.products.data.ProductDto
import com.example.quickstartlessons.module.products.data.ProductsDto
import kotlinx.coroutines.launch


class HomeMainTabViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {


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

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "Error data"
                    return true
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

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "Error data"
                    return true
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

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "Error data"
                    return true
                }
            }), isShowLoader, category)
        }
    }

}