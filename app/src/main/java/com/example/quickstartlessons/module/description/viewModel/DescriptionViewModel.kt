package com.example.quickstartlessons.module.description.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.repo.repository.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.products.data.response.model.products.ProductsDto
import kotlinx.coroutines.launch

// todo rename DescriptionViewModel to productDetailsViewModel
class DescriptionViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _productLiveData: MutableLiveData<ProductsDto?> = MutableLiveData()
    val productLiveData: LiveData<ProductsDto?>
        get() = _productLiveData

    private val _productErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val productErrorLiveData: LiveData<String>
        get() = _productErrorLiveData

    // todo rename getProduct to getProductById
    fun getProduct(isShoLoader: Boolean = true, id: Int) {
        viewModelScope.launch {
            repo.getProduct(object : ApiResultCallback<ProductsDto?> {
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