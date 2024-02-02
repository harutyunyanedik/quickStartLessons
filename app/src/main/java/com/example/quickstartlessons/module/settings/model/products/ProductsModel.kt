package com.example.quickstartlessons.module.settings.model.products

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsModel(
    @SerializedName("products")
    val products: List<ProductsDto>
): Serializable


