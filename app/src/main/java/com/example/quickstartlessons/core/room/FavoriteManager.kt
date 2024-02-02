package com.example.quickstartlessons.core.room

import com.example.quickstartlessons.core.room.dao.ProductDao
import com.example.quickstartlessons.core.room.data.ProductEntity
import com.example.quickstartlessons.module.settings.model.products.ProductsDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FavoriteManager(private val dao: ProductDao) {

    private val job = SupervisorJob()
    private val scope: CoroutineScope = CoroutineScope(job + Dispatchers.Default)

    fun insertProduct(product: ProductsDto) {
        scope.launch {
            dao.insertProduct(
                ProductEntity(
                    id = product.id,
                    title = product.title, price = product.price,
                    description = product.description, rating = product.rating,
                    brand = product.brand, category = product.category, thumbnail = product.thumbnail
                )
            )
        }
    }

    fun deleteProductById(product: ProductsDto) {
        scope.launch {
            dao.deleteProductById(product.id)
        }
    }

    fun getAllProducts() = dao.getAllProducts()
}