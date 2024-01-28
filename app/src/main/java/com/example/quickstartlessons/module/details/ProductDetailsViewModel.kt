package com.example.quickstartlessons.module.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.repo.Repository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.product.data.net.response.ProductDto
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val repo: Repository) : BaseObservableViewModel() {

    private val _productLiveData = MutableLiveData<ProductDto?>()
    val productLiveData: LiveData<ProductDto?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val productErrorLiveData: LiveData<String>
        get() = _productErrorLiveData

    fun getProductById(isShowLoader: Boolean = false, id: Int) {
        viewModelScope.launch {
            repo.getProductById(object: ApiResultCallback<ProductDto?>{
                override fun onSuccess(response: ProductDto?) {
                    _productLiveData.value = response
                }

                override fun onError(): Boolean { // todo setValue to _productErrorLiveData
                    return super.onError()
                }
            }, isShowLoader, id)
        }
    }
}


