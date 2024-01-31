package com.example.quickstartlessons.module.user.data.response

import com.example.quickstartlessons.module.product.data.model.response.ProductDto
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
    @SerializedName("maidenName")
    val maidenName: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("maidenName")
    val birthDate: Int

) :Serializable