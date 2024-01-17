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
}