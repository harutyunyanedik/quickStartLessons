package com.example.quickstartlessons.module.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.repo.Repository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.mappers.ProductMapper
import com.example.quickstartlessons.module.product.data.model.Product
import com.example.quickstartlessons.module.product.data.net.response.ProductsDto
import kotlinx.coroutines.launch

class SearchedProductsViewModel(private val repo: Repository) : BaseObservableViewModel() {
    private val mapper = ProductMapper()

    private val _searchedProductLiveData = MutableLiveData<List<Product>?>()
    val searchedProductsLiveData: LiveData<List<Product>?>
        get() = _searchedProductLiveData

    private val _searchedProductErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val searchedProductErrorLiveData: LiveData<String?>
        get() = _searchedProductErrorLiveData

    fun search(isShowLoader: Boolean = false, name: String) {
        viewModelScope.launch {
            repo.search(object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _searchedProductLiveData.value = mapper.listProductsDtoToListProducts(response)
                }

                override fun onError(): Boolean {
                    _searchedProductErrorLiveData.value = "The request failed"
                    return true
                }
            },isShowLoader, name)
        }
    }

    fun clearValue() {
        _searchedProductLiveData.value = emptyList()
    }
}