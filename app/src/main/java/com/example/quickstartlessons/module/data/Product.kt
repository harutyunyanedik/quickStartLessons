package com.example.quickstartlessons.module.data

data class Product( // todo product/data/model/
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    var isFavorite: Boolean = false
)