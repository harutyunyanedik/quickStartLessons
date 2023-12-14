package com.example.quickstartlessons.homework

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Photo(
    //@SerializedName("id")
    //val id: Int?= null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null
) : Serializable
