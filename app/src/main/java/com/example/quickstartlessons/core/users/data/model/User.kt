package com.example.quickstartlessons.core.users.data.model

import java.io.Serializable

data class User(
    val id: Int,
    val name: String,
    val lastName: String,
    val age: Int,
    val gender: String,
    val email: String,
    val phone: String,
    val birthDate: String,
    val image: String
) : Serializable
