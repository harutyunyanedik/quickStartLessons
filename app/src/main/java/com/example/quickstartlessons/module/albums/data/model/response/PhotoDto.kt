package com.example.quickstartlessons.module.albums.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PhotoDto(
    @SerializedName("albumId")
    val albumId : Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl:String? = null
) : Serializable
