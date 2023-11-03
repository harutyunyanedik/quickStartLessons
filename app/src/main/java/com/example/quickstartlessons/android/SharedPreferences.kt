package com.example.quickstartlessons.android

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit


fun Activity.putUserNameTo(key:String,value: String) {
    val putUserName=this.getSharedPreferences("main_act_shared_pref", android.content.Context.MODE_PRIVATE)
   putUserName.edit {
        putString("login", value)
       putString("password", value)
        apply()
    }
}

fun Activity.getUserNameFromPref(key: String): String {
    val getUserName =
        this.getSharedPreferences("main_act_shared_pref", android.content.Context.MODE_PRIVATE)
    return getUserName.getString("key", "").toString()
}