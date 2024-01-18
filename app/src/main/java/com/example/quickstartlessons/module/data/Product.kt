package com.example.quickstartlessons.module.data

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    var isFavorite: Boolean = false
)