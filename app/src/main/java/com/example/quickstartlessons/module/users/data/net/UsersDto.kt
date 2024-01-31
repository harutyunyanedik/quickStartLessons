package com.example.quickstartlessons.module.users.data.net

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersDto(
    @SerializedName("users")
    val users: List<UserDto>
) : Serializable
