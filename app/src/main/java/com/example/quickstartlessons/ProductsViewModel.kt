package com.example.quickstartlessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.data.ProductDto
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getProductsApi
import com.example.quickstartlessons.core.repo.ProductRepository
import com.example.quickstartlessons.core.repo.ProductsRepositoryImplementation
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    private val repo: ProductRepository = ProductsRepositoryImplementation(getProductsApi())

    private val _productLiveData: MutableLiveData<List<ProductDto>?> = MutableLiveData()
    val productLiveData: LiveData<List<ProductDto>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    fun getProducts(isShowLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getProductsV2((object : ApiResultCallback<List<ProductDto>?> {
                override fun onSuccess(response: List<ProductDto>?) {
                    _productLiveData.value = response
                }
            }), isShowLoader)
        }
    }
}