package com.example.quickstartlessons.module.albums.data.model.responce

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AlbumDto(
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
) : Serializable