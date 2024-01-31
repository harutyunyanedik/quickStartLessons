package com.example.quickstartlessons.core.room

import com.example.quickstartlessons.core.room.dao.ProductDao
import com.example.quickstartlessons.core.room.data.ProductEntity
import com.example.quickstartlessons.module.products.data.ProductDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FavoriteManager(private val dao: ProductDao) {

    private val job = SupervisorJob()
    private val scope: CoroutineScope = CoroutineScope(job + Dispatchers.Default)

    fun insertProduct(product: ProductDto) {
        scope.launch {
            dao.insertProduct(
                ProductEntity(
                    id = product.id,
                    title = product.title,
                    description = product.description,
                    price = product.price,
                    imageUrl = product.imageUrl
                )
            )
        }

    }

    fun deleteProduct(product: ProductDto) {
        scope.launch {
            dao.deleteProduct(
                ProductEntity(
                    id = product.id,
                    title = product.title,
                    description = product.description,
                    price = product.price,
                    imageUrl = product.imageUrl
                )
            )
        }

    }

    fun deleteProductByID(product: ProductDto) {
        scope.launch {
            dao.deleteProductById(product.id)
        }
    }

    fun getAllProducts() = dao.getAllProducts()

}