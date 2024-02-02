package com.example.quickstartlessons.module.user.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersDto(
    @SerializedName("users")
    val users: List<UserDto>
) : Serializable

data class UserDto(
    @SerializedName("id")
    val id:Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("maidenName") // todo maidenName
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
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("maidenName") // todo maidenName, 2 hat nuyn SerializedName na, dranica
    val birthDate: String

) :Serializable