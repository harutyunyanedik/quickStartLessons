package com.example.quickstartlessons.module.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.module.product.data.model.response.ProductDto
import com.example.quickstartlessons.module.product.data.model.response.ProductsDto
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.core.net.repository.ProductRepository
import com.example.quickstartlessons.core.net.repository.ProductRepositoryImplementation
import kotlinx.coroutines.launch

class HomeMainTabViewModel : ViewModel() {
    private val repository: ProductRepository = ProductRepositoryImplementation(getApi())

    private val _productLiveData: MutableLiveData<List<ProductDto>?> = MutableLiveData()
    val productLiveData: LiveData<List<ProductDto>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData
    private val _productLiveDataCategory: MutableLiveData<List<String>?> = MutableLiveData()
    val productLiveDataCategory: LiveData<List<String>?>
        get() = _productLiveDataCategory

    private val _productErrorLiveDataCategory: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveDataCategory: LiveData<String?>
        get() = _productErrorLiveDataCategory

    fun getProduct(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repository.getProducts(object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = response?.products
                }
            }, isShoLoader)
        }
    }

    fun getCategories(isShoLoader: Boolean = true, id: String) {
        viewModelScope.launch {
            repository.getCategories(object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response: List<String>?) {
                    _productLiveDataCategory.value = response

                }
            }, isShoLoader, id)

        }
    }
}
