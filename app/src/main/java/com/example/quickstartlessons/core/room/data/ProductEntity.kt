package com.example.quickstartlessons.core.room.data


data class ProductEntity(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    var isFavorite: Boolean = false
)
