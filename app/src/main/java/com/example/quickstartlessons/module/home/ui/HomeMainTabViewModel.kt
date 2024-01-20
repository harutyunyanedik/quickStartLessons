package com.example.quickstartlessons.module.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.module.product.data.model.response.ProductDto
import com.example.quickstartlessons.module.product.data.model.response.ProductsDto
import com.example.quickstartlessons.core.net.getApi
import com.example.quickstartlessons.core.net.repository.Repository
import com.example.quickstartlessons.core.net.repository.RepositoryImplementation
import kotlinx.coroutines.launch

class HomeMainTabViewModel : ViewModel() {
    private val repository: Repository = RepositoryImplementation(getApi())

    private val _productLiveData: MutableLiveData<List<ProductDto>?> = MutableLiveData()
    val productLiveData: LiveData<List<ProductDto>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData
    fun getProduct(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repository.getProducts(object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = response?.products
                }

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "Error data"
                    return true
                }

            }
            , isShoLoader)
        }
    }

    private val _categoryLiveData: MutableLiveData<List<String>?> = MutableLiveData()
    val categoryLiveData: LiveData<List<String>?>
        get() = _categoryLiveData

    private val _categoryErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val categoryErrorLiveData: LiveData<String?>
        get() = _categoryErrorLiveData


    fun getCategories(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repository.getCategories(object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response: List<String>?) {
                    _categoryLiveData.value = response
                }
            }, isShoLoader)
        }
    }
    private val _productByCategoryLiveData: MutableLiveData<ProductDto?> = MutableLiveData()
    val productByCategoryLiveData: LiveData<ProductDto?>
        get() = _productByCategoryLiveData

    private val _productByCategoryErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productByCategoryErrorLiveData: LiveData<String?>
        get() = _productByCategoryErrorLiveData

    fun geProductByCategory(isShoLoader: Boolean=true,id:String){
        viewModelScope.launch {
            repository.getProductByCategory(object :ApiResultCallback<ProductsDto?>{
                override fun onSuccess(response: ProductsDto?) {
                    _productByCategoryLiveData.value
                }
            },isShoLoader,id)
        }
    }
}
