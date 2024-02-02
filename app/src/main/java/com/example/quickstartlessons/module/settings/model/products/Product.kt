package com.example.quickstartlessons.module.settings.model.products

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val rating: String,
    val brand: String,
    val category: String,
    val thumbnail: String,
    var isFavorite:Boolean = false
)
