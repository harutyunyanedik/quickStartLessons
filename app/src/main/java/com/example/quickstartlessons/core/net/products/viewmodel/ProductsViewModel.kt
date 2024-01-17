package com.example.quickstartlessons.core.net.products.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.core.net.products.dto.ProductsDto
import com.example.quickstartlessons.core.net.products.dto.ProductDto
import com.example.quickstartlessons.core.net.products.repo.ProductsRepository
import com.example.quickstartlessons.core.net.products.repo.ProductsRepositoryImplementation
import kotlinx.coroutines.launch

class ProductsViewModel:ViewModel() {
    private val repo: ProductsRepository= ProductsRepositoryImplementation(getApi())


    private val _productLiveData: MutableLiveData<List<ProductsDto>?> = MutableLiveData()
    val productLiveData: LiveData<List<ProductsDto>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    fun getProducts(isShowLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getProductsV2((object : ApiResultCallback<ProductDto?> {
                override fun onSuccess(response: ProductDto?) {
                    _productLiveData.value = response
                }
            }), isShowLoader)
        }
    }
}