package com.example.quickstartlessons.module.albums.data.model.responce

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AlbumDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("userId")
    val userId: Int? = null
) : Serializable
