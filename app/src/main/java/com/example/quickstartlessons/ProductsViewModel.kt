package com.example.quickstartlessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.data.Products
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getProductsApi
import com.example.quickstartlessons.core.repo.ProductRepository
import com.example.quickstartlessons.core.repo.ProductsRepositoryImplementation
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    private val repo: ProductRepository = ProductsRepositoryImplementation(getProductsApi())

    private val _productLiveData: MutableLiveData<Products?> = MutableLiveData()
    val productLiveData: LiveData<Products?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    fun getProducts(isShowLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getProductsV2((object : ApiResultCallback<Products?> {
                override fun onSuccess(response: Products?) {
                    _productLiveData.value = response
                }
            }), isShowLoader)
        }
    }
}