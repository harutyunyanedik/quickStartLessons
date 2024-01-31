package com.example.quickstartlessons.module.products.data

import com.google.gson.annotations.SerializedName

data class Product (
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    val images: List<String>,
    var isFavorite:Boolean
)