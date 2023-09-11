package com.example.quickstartlessons

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        print("Hello world")
        super.onCreate(savedInstanceState, persistentState)
    }
}