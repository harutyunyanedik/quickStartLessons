package com.example.quickstartlessons.homework

import com.example.quickstartlessons.module.albums.data.net.datasource.AlbumDataSource
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val baseUrl="https://jsonplaceholder.typicode.com/"
val retrofitPhoto by lazy { createRetrofit()  }
fun createRetrofit():Retrofit=Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .client(clientHttp())
    .build()

fun clientHttp():OkHttpClient=OkHttpClient.Builder()
    .connectTimeout(60,TimeUnit.SECONDS)
    .readTimeout(60,TimeUnit.SECONDS)
    .addInterceptor(PhotoInterceptor())
    .build()

  class PhotoInterceptor():Interceptor {
      override fun intercept(chain: Interceptor.Chain): Response {
          val request = chain.request()
              .newBuilder()
              .build()
          return chain.proceed(request)
      }
  }

   val apiPhoto:PhotoDataSource = getApiService()
inline fun <reified T> getApiService(): T {
    return retrofitPhoto.create(T::class.java)
}

interface ApiResultCallback<T> {
    fun onSuccess(response: T)

    fun onError(): Boolean = false

    fun onNotHandledError(error: Any? = null) {}
}