package com.example.quickstartlessons.module.home.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.getProduct
import com.example.quickstartlessons.module.products.data.response.model.ProductsModel
import com.example.quickstartlessons.core.net.repo.repository.ProductRepositoryImplementation
import com.example.quickstartlessons.core.net.repo.repository.ProductsRepository
import kotlinx.coroutines.launch

class HomeMainTabViewModel: ViewModel() {

    private val repo: ProductsRepository = ProductRepositoryImplementation(getProduct())

    private val _productsLiveData: MutableLiveData<ProductsModel?> = MutableLiveData()
    val productsLiveData: LiveData<ProductsModel?>
        get() = _productsLiveData

    private val _productErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val productErrorLiveData: LiveData<String?>
        get() = _productErrorLiveData

    private val _categoriesLiveData: MutableLiveData<List<String>?> = MutableLiveData()
    val categoriesLiveData: LiveData<List<String>?>
        get() = _categoriesLiveData

    private val _categoriesErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val categoriesErrorLiveData: LiveData<String?>
        get() = _categoriesErrorLiveData

    fun getCategories(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAllCategories(object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response:List<String>?) {
                    _categoriesLiveData.value = response
                }
            }, false)
        }
    }

    fun getProducts(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAllProducts(object : ApiResultCallback<ProductsModel?> {
                override fun onSuccess(response: ProductsModel?) {
                    _productsLiveData.value = response
                }
            }, isShoLoader)
        } // todo add error case
    }

    private val _categoriesLiveData: MutableLiveData<List<String>?> = MutableLiveData()
    val categoriesLiveData: LiveData<List<String>?>
        get() = _categoriesLiveData

    private val _categoriesErrorLiveData: MutableLiveData<String?> = MutableLiveData()
    val categoriesErrorLiveData: LiveData<String?>
        get() = _categoriesErrorLiveData

    fun getCategories(isShoLoader: Boolean = false) {
        viewModelScope.launch {
            repo.getAllCategories(object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response:List<String>?) {
                    _categoriesLiveData.value = response
                }
            }, isShoLoader)
        } // todo add error case
    }
}