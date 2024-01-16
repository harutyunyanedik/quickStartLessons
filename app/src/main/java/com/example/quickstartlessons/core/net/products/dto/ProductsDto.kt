package com.example.quickstartlessons.core.net.products.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsDto (
  @SerializedName("id")
  val productId: Int,
  @SerializedName("title")
  val title: String,
  @SerializedName("description")
  val description: String,
  @SerializedName("price")
  val price: Int
 ):Serializable