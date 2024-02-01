package com.example.quickstartlessons.module.account.responceModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersModel(
    @SerializedName("users")
    val users: List<UsersDto>
) : Serializable


