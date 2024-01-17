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

    fun getProduct(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repository.getProducts(object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = response?.products
                }
            }, isShoLoader)
        }
    }

}