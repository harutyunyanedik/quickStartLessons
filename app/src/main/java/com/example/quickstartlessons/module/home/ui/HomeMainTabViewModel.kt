package com.example.quickstartlessons.module.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.core.net.products.dto.ProductDto
import com.example.quickstartlessons.core.net.products.dto.ProductsDto
import com.example.quickstartlessons.core.net.products.repo.ProductsRepository
import com.example.quickstartlessons.core.net.products.repo.ProductsRepositoryImplementation
import kotlinx.coroutines.launch

class HomeMainTabViewModel : ViewModel() {
    private val repo: ProductsRepository = ProductsRepositoryImplementation(getApi())


    private val _productLiveData: MutableLiveData<List<ProductDto>?> = MutableLiveData()
    val productLiveData: LiveData<List<ProductDto>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    fun getProducts(isShowLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getProductsV2((object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = response?.products
                }
            }), isShowLoader)
        }
    }
}