package com.example.quickstartlessons

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.api.ApiService
import com.example.quickstartlessons.data.model.AlbumDto
import com.example.quickstartlessons.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViews()
        setupRetrofit()
    }

    private fun setupViews() {

    }

    private fun setupRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val call = apiService.getAlbums()
        call.enqueue(object : Callback<AlbumDto?> {
            override fun onResponse(call: Call<AlbumDto?>, response: Response<AlbumDto?>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    println(data)
                } else {
                    // show popup
                }
            }

            override fun onFailure(call: Call<AlbumDto?>, t: Throwable) {
                // show dialog
            }
        })
    }

}