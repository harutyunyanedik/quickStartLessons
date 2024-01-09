package com.example.quickstartlessons.module.login
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
import com.example.quickstartlessons.MainActivity



fun MainActivity.setLoginPassword (key:String,value:String) {

    val sharedPreferences=getSharedPreferences("Save data", MODE_PRIVATE)
    sharedPreferences.edit {
        putString(key, value)
        apply()
    }
}
fun MainActivity.getLoginPassword (key:String):String {

    val sharedPreferences=getSharedPreferences("Save data", MODE_PRIVATE)
    sharedPreferences.edit {
        putString(key, VALUE)
    }
    return VALUE
}
 const val KEY="key"
const val VALUE="value"
