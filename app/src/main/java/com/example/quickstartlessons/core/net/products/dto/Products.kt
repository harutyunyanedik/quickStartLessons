package com.example.quickstartlessons.core.net.products.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Products(
    @SerializedName("products")
    val products: List<ProductsDto>
) :Serializable
