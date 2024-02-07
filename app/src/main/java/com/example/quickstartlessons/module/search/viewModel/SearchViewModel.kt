package com.example.quickstartlessons.module.search.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.room.dao.net.ApiResultCallback
import com.example.quickstartlessons.core.room.dao.net.repo.repository.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.settings.model.products.ProductsModel
import kotlinx.coroutines.launch

class SearchViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _searchProductsLiveData: MutableLiveData<ProductsModel?> = MutableLiveData()
    val searchProductsLiveData: LiveData<ProductsModel?>
        get() = _searchProductsLiveData

    private val _searchProductsErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val searchProductsErrorLiveData: LiveData<String>
        get() = _searchProductsErrorLiveData

    fun Search(isShoLoader: Boolean = true,name:String) {
        viewModelScope.launch {
            repo.search(object : ApiResultCallback<ProductsModel?> {
                override fun onSuccess(response: ProductsModel?) {
                    _searchProductsLiveData.value = response
                }

                override fun onError(): Boolean {
                    _searchProductsErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader, name)
        }
    }
}