package com.example.quickstartlessons.core.net

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductData(

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

): Serializable

