package com.example.quickstartlessons.core.users.data.net

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("maidenName")
    val maidenName: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val userName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("birthDate")
    val birthDate: String,
    @SerializedName("image")
    val image: String
) : Serializable
