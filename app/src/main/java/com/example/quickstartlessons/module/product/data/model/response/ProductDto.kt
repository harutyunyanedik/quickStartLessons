package com.example.quickstartlessons.module.product.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsDto(
    @SerializedName("products")
    val products: List<ProductDto>
) : Serializable

data class ProductDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("discountPercentage")
    val discountPercentage: Float,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("stock ") // todo stex el nayi "stock " probel uni dra hamar el data ches stanum, es SerializedName e petqa lini nuyn json i ke i anunov
    val stock: Int,
    @SerializedName("images") // todo json e vor nayes endex key voch te image a ayl images dra hamr du null es stanum, stex poxi dir chisht key e u kashxati
    val image: List<String>,
    var favorite: Boolean = false
) : Serializable

