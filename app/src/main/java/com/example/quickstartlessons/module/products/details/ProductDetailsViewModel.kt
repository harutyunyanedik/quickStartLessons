package com.example.quickstartlessons.module.products.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.repo.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.products.data.ProductDto
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {
    private val _productDetailsLiveData: MutableLiveData<ProductDto?> = MutableLiveData()
    val productDetailsLiveData: MutableLiveData<ProductDto?>
        get() = _productDetailsLiveData

    private val _productDetailsErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productDetailsErrorLiveData: LiveData<String?>
        get() = _productDetailsErrorLiveData

    fun getProductsDetail(isShowLoader: Boolean = false, id: Int) {
        viewModelScope.launch {
            repo.getProductById((object : ApiResultCallback<ProductDto?> {
                override fun onSuccess(response: ProductDto?) {
                    _productDetailsLiveData.value = response
                }

                override fun onError(): Boolean {
                    _productDetailsErrorLiveData.value = "Error data"
                    return true
                }
            }), isShowLoader, id)
        }
    }
}