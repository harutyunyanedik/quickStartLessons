package com.example.quickstartlessons.tablayout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repo: ProductRepo = ProductRepositoryImplementation(getApi())

  private val _productLiveData: MutableLiveData<Product?> = MutableLiveData()
     val productLiveData: LiveData<Product?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<Product?> = MutableLiveData()
  val productErrorLiveData: LiveData<Product?>
        get() = _productErrorLiveData

    fun getProduct(isShowLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getProducts(object : ApiResultCallback<Product?> {
                override fun onSuccess(response: Product?) {
                    _productLiveData.value = response
                }
            }, isShowLoader)
        }

    }
}