package com.example.quickstartlessons.module.mappers

import com.example.quickstartlessons.core.users.data.model.User
import com.example.quickstartlessons.core.users.data.net.UserDto

class UserMapper {

    fun userDtoToUser(userDto: UserDto) = User(
        id = userDto.id,
        name = userDto.firstName,
        lastName = userDto.lastName,
        age = userDto.age,
        gender = userDto.gender,
        email = userDto.email,
        phone = userDto.phone,
        birthDate = userDto.birthDate,
        image = userDto.image
    )
}