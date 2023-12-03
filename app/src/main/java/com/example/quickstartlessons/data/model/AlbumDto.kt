package com.example.quickstartlessons.data.model

import com.google.gson.annotations.SerializedName

data class AlbumDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("userId")
    val userId: Int? = null
)