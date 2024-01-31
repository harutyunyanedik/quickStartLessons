package com.example.quickstartlessons.module.product.data.model.response

data class Product (
    val id:Int,
    val title: String,
    val description: String,
    val price: Int,
    val brand: String,
    val thumbnail: String,
    var favorite: Boolean = false){
}