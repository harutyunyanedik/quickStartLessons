package com.example.quickstartlessons.module.account.responceModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersDto(
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
    val phone: Int // todo java.lang.NumberFormatException: For input string: "+63 791 675 8914"
) : Serializable
