package com.example.quickstartlessons.android

import android.app.Activity
import androidx.core.content.edit

fun Activity.sharedPrefs() = this.getSharedPreferences("main_act_shared_pref", android.content.Context.MODE_PRIVATE)

fun Activity.putUserNameToPref(value: String) {
    this.sharedPrefs().edit {
        putString("key_user_name", value)
        apply()
    }
}

fun Activity.getUserNameFromPref() = this.sharedPrefs().getString("key_user_name", null)
