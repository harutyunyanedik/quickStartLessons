package com.example.quickstartlessons.module.products.data.response.model

import com.google.gson.annotations.SerializedName

data class ProductsModel(
    @SerializedName("products")
    val products: List<ProductsDto>
)
