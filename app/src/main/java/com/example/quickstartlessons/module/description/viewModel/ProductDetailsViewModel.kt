package com.example.quickstartlessons.module.description.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.room.dao.net.ApiResultCallback
import com.example.quickstartlessons.core.room.dao.net.repo.repository.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.settings.model.products.ProductsDto
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _productLiveData: MutableLiveData<ProductsDto?> = MutableLiveData()
    val productLiveData: LiveData<ProductsDto?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val productErrorLiveData: LiveData<String>
        get() = _productErrorLiveData

    fun getProductById(isShoLoader: Boolean = true, id: Int) {
        viewModelScope.launch {
            repo.getProductById(object : ApiResultCallback<ProductsDto?> {
                override fun onSuccess(response: ProductsDto?) {
                    _productLiveData.value = response
                }

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader, id)
        }
    }

}