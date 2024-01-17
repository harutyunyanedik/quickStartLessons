package com.example.quickstartlessons.core.net.products.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsDto(
    @SerializedName("products")
    val products: List<ProductDto>
) :Serializable
