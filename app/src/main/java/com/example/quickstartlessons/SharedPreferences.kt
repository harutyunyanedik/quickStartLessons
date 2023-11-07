package com.example.quickstartlessons

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
  fun Activity.sharedPref()=this.getSharedPreferences("data", MODE_PRIVATE)


fun  Activity. setSharedValue( key:String, value:String){
       sharedPref().edit {
           putString(key,value)
           apply()
    }
}
fun Activity.getSharedValue(key:String) :String{
    return sharedPref().getString(key," ").toString()

}
