package com.example.quickstartlessons.data.model

import com.google.gson.annotations.SerializedName

data class AlbumDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("userId")
    val userId: Int? = null
)

//private fun setupRetrofit() {
//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://jsonplaceholder.typicode.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val apiService = retrofit.create(ApiService::class.java)
//    val call = apiService.getAlbums()
//    call.enqueue(object : Callback<AlbumDto?> {
//        override fun onResponse(call: Call<AlbumDto?>, response: Response<AlbumDto?>) {
//            if (response.isSuccessful) {
//                val data = response.body()
//                println(data)
//            } else {
//                // show popup
//            }
//        }
//
//        override fun onFailure(call: Call<AlbumDto?>, t: Throwable) {
//            // show dialog
//        }
//    })
//}