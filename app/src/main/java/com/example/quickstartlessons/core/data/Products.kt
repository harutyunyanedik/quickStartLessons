package com.example.quickstartlessons.core.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Products(
    @SerializedName("products")
    val products: List<ProductDto>
) : Serializable
