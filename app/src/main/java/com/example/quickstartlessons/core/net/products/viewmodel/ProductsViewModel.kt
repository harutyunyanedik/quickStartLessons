package com.example.quickstartlessons.core.net.products.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.core.net.products.dto.ProductsDto
import com.example.quickstartlessons.core.net.products.repo.ProductRepository
import com.example.quickstartlessons.core.net.products.repo.ProductRepositoryImplementation
import kotlinx.coroutines.launch

class ProductsViewModel:ViewModel() {
    private val repo: ProductRepository = ProductRepositoryImplementation(getApi())

    private val _productLiveData: MutableLiveData<List<ProductsDto>?> = MutableLiveData()
    val productLiveData: LiveData<List<ProductsDto>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    fun getProducts(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAlbumsV2(object : ApiResultCallback<List<ProductsDto>?> {
                override fun onSuccess(response: List<ProductsDto>?) {
                    _productLiveData.value = response
                }
            }, isShoLoader)
        }
    }
}