package com.example.quickstartlessons.module.albums.newpresenttation


import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private lateinit var sharedPreferences: SharedPreferences
private const val KEY_TITLE = "key_title"
private const val KAY_MASSAGE = "key_massage"

  fun Activity.sharedPrefs() = this.getSharedPreferences("main_act_shared_pref", Context.MODE_PRIVATE)!!

fun Activity.putTitleToPref(value: String) {
    sharedPrefs().edit {
        putString(KEY_TITLE, value)
        apply()
    }
}

fun Activity.putMassageToPref(value: String) {
    sharedPrefs().edit {
        putString(KAY_MASSAGE, value)
        apply()
    }
}

fun Activity.getTitleFromPref() {
    this.sharedPrefs().getString(KEY_TITLE, null).toString()
}

fun Activity.getMassageFromPref() {
    this.sharedPrefs().getString(KAY_MASSAGE, null).toString()
}



