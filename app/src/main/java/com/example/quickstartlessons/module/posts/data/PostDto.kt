package com.example.quickstartlessons.module.posts.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostDto(
    @SerializedName("body")
    val body: String,
    @SerializedName("title")
    val description: String
):Serializable