package com.example.quickstartlessons

object UsersList {

    private val users = mutableListOf<User>()

    fun getUserByEmail(email: String) : User? {
        var wantedUser : User? = null
        for (user in users){
            if (email == user.email){
                wantedUser = user
            }
        }
        return wantedUser
    }

    fun getUserByPhoneNumber(phoneNumber: Int) : User? {
        var wantedUser : User? = null
        for (user in users){
            if (phoneNumber == user.phoneNumber){
                wantedUser = user
            }
        }
        return wantedUser
    }

    fun findUserByUserName(username: String) : Boolean{
        var contains = false
        for (user in users){
            if (username == user.username){
                contains =  true
                break
            }
        }
        return contains
    }

    fun addUser(user: User){
        users.add(user)
    }
    fun removeUser(user: User){
        users.remove(user)
    }
}
