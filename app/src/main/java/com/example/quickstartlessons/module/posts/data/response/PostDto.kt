package com.example.quickstartlessons.module.posts.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
) : Serializable


