package com.example.quickstartlessons.module.product
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.ProductData
import com.example.quickstartlessons.core.net.getApiProduct
import com.example.quickstartlessons.core.net.repository.ProductRepository
import com.example.quickstartlessons.core.net.repository.ProductRepositoryImplementation
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {
    private val repository:ProductRepository=ProductRepositoryImplementation(getApiProduct())
   private val _productLiveData:MutableLiveData<List<ProductData>?> = MutableLiveData()
    val productLiveData:LiveData<List<ProductData>?>
        get()=_productLiveData
    private val  _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData:LiveData<String?>
        get()=_productErrorLiveData
    fun getProduct(isShoLoader: Boolean=true){
        viewModelScope.launch {
            repository.getProducts(object:ApiResultCallback<List<ProductData>?>{
                override fun onSuccess(response: List<ProductData>?) {
                  _productLiveData.value=response
                }
            },isShoLoader)
        }
    }

}