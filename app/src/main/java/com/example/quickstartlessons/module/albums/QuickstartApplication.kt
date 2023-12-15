package com.example.quickstartlessons.module.albums

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.lifecycle.MutableLiveData

class QuickstartApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        listenToNetworkChange()
    }

    private fun listenToNetworkChange() {
        val networkCallback: ConnectivityManager.NetworkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                networkStateLiveData.postValue(true)
            }

            override fun onLost(network: Network) {
                networkStateLiveData.postValue(false)
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

    companion object {
        val networkStateLiveData: MutableLiveData<Boolean> = MutableLiveData()
    }

}