package com.example.quickstartlessons.core.net.viewModel // todo  module/home/ui/

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getProduct
import com.example.quickstartlessons.core.net.repo.model.ProductsModel
import com.example.quickstartlessons.core.net.repo.repository.ProductRepositoryImplementation
import com.example.quickstartlessons.core.net.repo.repository.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {

    private val repo: ProductsRepository = ProductRepositoryImplementation(getProduct())

    private val _productsLiveData: MutableLiveData<ProductsModel?> = MutableLiveData()
    val productsLiveData: LiveData<ProductsModel?>
        get() = _productsLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    fun getProducts(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAllProducts(object : ApiResultCallback<ProductsModel?> {
                override fun onSuccess(response: ProductsModel?) {
                    _productsLiveData.value = response
                }
            }, isShoLoader)
        }
    }
}