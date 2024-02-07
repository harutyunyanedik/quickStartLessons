package com.example.quickstartlessons.module.postsmodel.data.net.responce

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)
