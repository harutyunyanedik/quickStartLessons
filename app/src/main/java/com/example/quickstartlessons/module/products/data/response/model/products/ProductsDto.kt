package com.example.quickstartlessons.module.products.data.response.model.products

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("thumbnail")
    val thumbnail: String
) : Serializable{
    fun ProductsDto.toProduct() = Product(
        id = id,
       title = title,
        description = description,
        price = price,
        rating = rating,
        brand = brand,
        category = category,
        thumbnail = thumbnail,
    )
}
