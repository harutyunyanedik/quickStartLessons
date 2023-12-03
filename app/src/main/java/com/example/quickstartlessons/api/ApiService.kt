package com.example.quickstartlessons.api

import com.example.quickstartlessons.data.model.AlbumDto
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("albums/1")
    fun getAlbums(): Call<AlbumDto>
}