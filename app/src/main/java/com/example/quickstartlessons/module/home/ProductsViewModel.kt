package com.example.quickstartlessons.module.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.repo.Repository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.category.data.model.Category
import com.example.quickstartlessons.module.mappers.ProductMapper
import com.example.quickstartlessons.module.product.data.model.Product
import com.example.quickstartlessons.module.product.data.net.response.ProductsDto
import kotlinx.coroutines.launch

class ProductsViewModel(private val repo: Repository) : BaseObservableViewModel() {
    private val mapper = ProductMapper()

    private val _productLiveData: MutableLiveData<List<Product>?> = MutableLiveData()
    val productLiveData: LiveData<List<Product>?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    fun getProducts(isShowLoader: Boolean = false) {
        viewModelScope.launch {
            repo.getProductsV2((object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = mapper.listProductsDtoToListProducts(response)
                }

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "The request failed"
                    return true
                }
            }), isShowLoader)
        }
    }

    private val _categoryLiveData: MutableLiveData<List<Category>?> = MutableLiveData()

    val categoryLiveData: LiveData<List<Category>?>
        get() = _categoryLiveData

    private val _categoryErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val categoryErrorLiveData: LiveData<String?>
        get() = _categoryErrorLiveData

    fun getCategories(isShowLoader: Boolean = false) {
        viewModelScope.launch {
            repo.getCategories((object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response: List<String>?) {
                    _categoryLiveData.value = mapper.listStringToListCategory(response)
                }

                override fun onError(): Boolean {
                    _categoryErrorLiveData.value = "The request failed"
                    return true
                }
            }), isShowLoader)
        }
    }

    fun getProductsByCategory(isShowLoader: Boolean = false, category: String) {
        viewModelScope.launch {
            repo.getProductsByCategory((object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = mapper.listProductsDtoToListProducts(response)
                }

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "The request failed"
                    return true
                }
            }), isShowLoader, category)
        }
    }
}