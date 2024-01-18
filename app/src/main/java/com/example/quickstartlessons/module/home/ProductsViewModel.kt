package com.example.quickstartlessons.module.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getProductsApi
import com.example.quickstartlessons.core.repo.ProductRepository
import com.example.quickstartlessons.core.repo.ProductsRepositoryImplementation
import com.example.quickstartlessons.module.data.ProductsDto
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    private val repo: ProductRepository = ProductsRepositoryImplementation(getProductsApi())

    private val _productLiveData: MutableLiveData<ProductsDto?> = MutableLiveData()
    val productLiveData: LiveData<ProductsDto?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()  // todo handle error case
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    private val _categoryLiveData: MutableLiveData<List<String>?> = MutableLiveData()

    val categoryLiveData: LiveData<List<String>?>
        get() = _categoryLiveData

    private val _categoryErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val categoryErrorLiveData: LiveData<String?>
        get() = _categoryErrorLiveData

    fun getProducts(isShowLoader: Boolean = false) {
        viewModelScope.launch {
            repo.getProductsV2((object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = response
                }

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "The request failed"
                    return true
                }
            }), isShowLoader)
        }
    }

    fun getCategories(isShowLoader: Boolean = false) {
        viewModelScope.launch {
            repo.getCategories((object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response: List<String>?) {
                    _categoryLiveData.value = response
                }

                override fun onError(): Boolean {
                    _categoryErrorLiveData.value = "The request failed"
                    return true
                }
            }), isShowLoader)
        }
    }

    fun getProductsByCategory(isShowLoader: Boolean = false, category: String) {
        viewModelScope.launch {
            repo.getProductsByCategory((object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                   _productLiveData.value = response
                }

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "The request failed"
                    return true
                }
            }), isShowLoader, category)
        }
    }
}