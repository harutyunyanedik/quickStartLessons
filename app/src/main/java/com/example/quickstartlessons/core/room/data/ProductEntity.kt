package com.example.quickstartlessons.core.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    var isFavorite: Boolean = false
)
