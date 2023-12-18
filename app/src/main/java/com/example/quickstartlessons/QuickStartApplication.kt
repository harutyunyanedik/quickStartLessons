package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.MutableLiveData

class QuickStartApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        listenToNetworkChange()
    }

    @SuppressLint("MissingPermission")
    private fun listenToNetworkChange() {
        val networkCallback: ConnectivityManager.NetworkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                networkStateLiveData.postValue(true)
            }

            override fun onLost(network: Network) {
                networkStateLiveData.postValue(false)
                showAlertDialog()
            }
        }

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        } else {
            val request = NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build()
            connectivityManager.registerNetworkCallback(request, networkCallback)
        }
    }

    fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("Internet is not available")
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.setCancelable(false)
        if (!alertDialog.isShowing) {
            alertDialog.show()
        }
    }

    companion object {
        val networkStateLiveData: MutableLiveData<Boolean> = MutableLiveData()
    }
}