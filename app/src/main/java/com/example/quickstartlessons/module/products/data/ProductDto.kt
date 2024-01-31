package com.example.quickstartlessons.module.products.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductDto(
  @SerializedName("id")
  val id: Int,
  @SerializedName("title")
  val title: String,
  @SerializedName("description")
  val description: String,
  @SerializedName("price")
  val price: Int,
  @SerializedName("thumbnail")
  val imageUrl: String,
  @SerializedName("images")
  val images: List<String>,
  @SerializedName("favorite")
  var isFavorite: Boolean = false
) : Serializable
