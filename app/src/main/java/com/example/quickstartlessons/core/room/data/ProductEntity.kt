package com.example.quickstartlessons.core.room.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val rating: String,
    val brand: String,
    val category: String,
    val thumbnail: String,
    var isFavorite:Boolean = false
)
