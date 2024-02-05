package com.example.quickstartlessons.module.home.ui.searchedProducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.repo.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.products.data.ProductDto
import com.example.quickstartlessons.module.products.data.ProductsDto
import kotlinx.coroutines.launch

class SearchedProductsViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _searchedProductLiveData = MutableLiveData<List<ProductDto>?>()
    val searchedProductsLiveData: LiveData<List<ProductDto>?>
        get() = _searchedProductLiveData

    private val _searchedProductErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val searchedProductErrorLiveData: LiveData<String?>
        get() = _searchedProductErrorLiveData

    fun getSearchedProductsByName(isShowLoader: Boolean = false, name: String) {
        viewModelScope.launch {
            repo.search(object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _searchedProductLiveData.value = response?.products
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