package com.example.quickstartlessons.module.products.data.response.model.products

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsModel(
    @SerializedName("products")
    val products: List<ProductsDto>
): Serializable


