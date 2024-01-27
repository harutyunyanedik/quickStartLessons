package com.example.quickstartlessons.module.home.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.repo.repository.ProductsRepository
import com.example.quickstartlessons.module.base.viewmodel.BaseObservableViewModel
import com.example.quickstartlessons.module.products.data.response.model.products.ProductsModel
import kotlinx.coroutines.launch

class HomeMainTabViewModel(private val repo: ProductsRepository) : BaseObservableViewModel() {

    private val _productsLiveData: MutableLiveData<ProductsModel?> = MutableLiveData()
    val productsLiveData: LiveData<ProductsModel?>
        get() = _productsLiveData

    private val _productErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val productErrorLiveData: LiveData<String>
        get() = _productErrorLiveData

    fun getProducts(isShoLoader: Boolean = true) {
        viewModelScope.launch {
            repo.getAllProducts(object : ApiResultCallback<ProductsModel?> {
                override fun onSuccess(response: ProductsModel?) {
                    _productsLiveData.value = response
                }

                override fun onError(): Boolean {
                    _productErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader)
        }
    }

    private val _categoriesLiveData: MutableLiveData<List<String>?> = MutableLiveData()
    val categoriesLiveData: LiveData<List<String>?>
        get() = _categoriesLiveData

    private val _categoriesErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val categoriesErrorLiveData: LiveData<String>
        get() = _categoriesErrorLiveData

    fun getCategories(isShoLoader: Boolean = false) {
        viewModelScope.launch {
            repo.getAllCategories(object : ApiResultCallback<List<String>?> {
                override fun onSuccess(response:List<String>?) {
                    _categoriesLiveData.value = response
                }

                override fun onError(): Boolean {
                    _categoriesErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader)
        }
    }

    private val _productsByCategoryErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val productsByCategoryErrorLiveData: LiveData<String>
        get() = _productsByCategoryErrorLiveData

    private val _productsByCategoryLiveData: MutableLiveData<ProductsModel?> = MutableLiveData()
    val productsByCategoryLiveData: LiveData<ProductsModel?>
        get() = _productsByCategoryLiveData

    fun getProductsByCategory(isShoLoader: Boolean = false, categoryName: String) {
        viewModelScope.launch {
            repo.getProductsByCategory(object : ApiResultCallback<ProductsModel?> {
                override fun onSuccess(response: ProductsModel?) {
                    _productsByCategoryLiveData.value = response
                    _productsLiveData.value = _productsByCategoryLiveData.value
                }

                override fun onError(): Boolean {
                    _productsByCategoryErrorLiveData.value = "Unknown error"
                    return super.onError()
                }
            }, isShoLoader, categoryName)
        }
    }
}