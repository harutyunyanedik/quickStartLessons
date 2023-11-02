package com.example.quickstartlessons

import android.app.Activity
import androidx.core.content.edit

fun Activity.sharedPref() = getSharedPreferences("main_act_shared_pref", android.content.Context.MODE_PRIVATE)

fun Activity.putUserNameAndPassword(username: String, password: String){
    sharedPref().edit {
        putString(username, password)
        apply()
    }
}

fun Activity.getUserNameAndPassword(username: String) = sharedPref().getString(username, "")