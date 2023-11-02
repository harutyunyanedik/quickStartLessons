package com.example.quickstartlessons.kotlin

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit



fun  Activity. setValue( key:String, value:String){
    val sharedPref =this.getSharedPreferences("login_password data", MODE_PRIVATE)
    sharedPref.edit {
           putString("login",value)
           putString("password", value)
           apply()
    }
}
fun Activity.getValue(key:String) :String{
    val sharedPref =this.getSharedPreferences("login_password data", MODE_PRIVATE)
    return sharedPref.getString("login"," ").toString()
    return sharedPref.getString("password", " ").toString()
}
