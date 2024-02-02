package com.example.quickstartlessons.module.account.responceModel // todo package account/data/response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsersModel( // todo rename UsersDto
    @SerializedName("users")
    val users: List<UsersDto> // todo rename UserDto
) : Serializable


