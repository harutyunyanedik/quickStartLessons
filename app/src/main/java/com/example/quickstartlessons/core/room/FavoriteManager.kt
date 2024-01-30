package com.example.quickstartlessons.core.room

import com.example.quickstartlessons.core.room.dao.ProductDao
import com.example.quickstartlessons.core.room.data.ProductEntity
import com.example.quickstartlessons.module.product.data.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FavoriteManager(private val dao: ProductDao) {

    private val job = SupervisorJob()
    private val scope: CoroutineScope = CoroutineScope(job + Dispatchers.Default)

    fun insertProduct(product: Product) {
        scope.launch {
            dao.insertProduct(ProductEntity(id=product.id,
                title = product.title,
                description = product.description,
                price = product.price,
                imageUrl = product.imageUrl))
        }
    }

    fun deleteProduct(id: Int) {
        scope.launch {
            dao.deleteProduct(id)
        }
    }

    fun getAllProducts() = dao.getAllProducts()
}