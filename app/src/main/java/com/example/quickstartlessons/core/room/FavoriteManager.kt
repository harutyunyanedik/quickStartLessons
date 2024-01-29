package com.example.quickstartlessons.core.room

import com.example.quickstartlessons.core.room.dao.ProductDao
import com.example.quickstartlessons.core.room.data.ProductEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FavoriteManager(private val dao: ProductDao) {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(job + Dispatchers.Default)

    fun insertProduct(id: Int, name: String) {
        scope.launch {
            dao.insertProduct(ProductEntity(id, name))
        }
    }

    fun deleteProduct(id: Int) {
        scope.launch {
            dao.deleteProduct(ProductEntity(id, "mnbc"))
        }
    }

    fun getAllProducts() = dao.getAllProducts()
}