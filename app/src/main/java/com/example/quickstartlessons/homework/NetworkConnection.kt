@file:Suppress("DEPRECATION")

package com.example.quickstartlessons.homework

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.widget.Toast
import androidx.fragment.app.Fragment

@SuppressLint("SuspiciousIndentation")
fun isConnected(context: Context, isConnected:Boolean) {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val netInfo = cm.activeNetworkInfo
        if (isConnected) netInfo?.isConnectedOrConnecting
         else {
            Toast.makeText(context, "No internet connection", Toast.LENGTH_SHORT).show()
        }
    }
}