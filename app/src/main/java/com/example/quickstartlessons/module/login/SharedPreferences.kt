package com.example.quickstartlessons.module.login
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
import com.example.quickstartlessons.MainActivity



fun Activity.setLoginPassword (key:String, value:String) {

    val sharedPreferences=getSharedPreferences("Save data", MODE_PRIVATE)
    sharedPreferences.edit {
        putString(key, value)
        apply()
    }
}
@SuppressLint("SuspiciousIndentation")
fun Activity.getLoginPassword (key:String):String {

    val sharedPreferences=getSharedPreferences("Save data", MODE_PRIVATE)

       return sharedPreferences.getString(key," ").toString()

}
