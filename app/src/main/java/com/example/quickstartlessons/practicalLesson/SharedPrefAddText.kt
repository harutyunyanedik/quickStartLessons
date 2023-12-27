package com.example.quickstartlessons.practicalLesson
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit

@SuppressLint("SuspiciousIndentation")
fun Activity.saveData(key:String, value:String) {
    val sharedPref = getSharedPreferences("data", MODE_PRIVATE)
         sharedPref.edit {
             putString(key,value)
             apply()
         }
    }
fun Activity.getText(key:String): String {
    val sharedPref = getSharedPreferences("data", MODE_PRIVATE)
    return sharedPref.getString(key," ").toString()
}