package com.example.quickstartlessons.module.Users.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("birthDate")
    val birthDate: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName(" password")
    val  password: String
) : Serializable
