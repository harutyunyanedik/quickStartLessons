package com.example.quickstartlessons.todolist.presentation

import android.app.Activity
import android.content.SharedPreferences
import androidx.core.content.edit

fun Activity.sharedPrefs() : SharedPreferences = this.getSharedPreferences("main_act_shared_pref", android.content.Context.MODE_PRIVATE)

fun Activity.putTodo(value: String){
    this.sharedPrefs().edit {
        putString("todos", value)
        apply()
    }
}

fun Activity.getTodo() = this.sharedPrefs().getString("todos", "")
