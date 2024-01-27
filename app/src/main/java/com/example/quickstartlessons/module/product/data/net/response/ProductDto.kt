package com.example.quickstartlessons.module.product.data.net.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("thumbnail")
    val imageUrl: String,
    @SerializedName("images")
    val images: List<String>
) : Serializable
