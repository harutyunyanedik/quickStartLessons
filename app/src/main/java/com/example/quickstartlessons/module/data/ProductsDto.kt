package com.example.quickstartlessons.module.data

import com.example.quickstartlessons.module.data.ProductDto
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsDto(
    @SerializedName("products")
    val products: List<ProductDto>
) : Serializable

