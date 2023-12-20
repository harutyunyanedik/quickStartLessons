package com.example.quickstartlessons.tablayout

import com.example.quickstartlessons.module.albums.data.net.datasource.AlbumDataSource
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit




    private const val baseUrl = "https://dummyjson.com/"

    val retrofitProduct by lazy { productRetrofit() }


    private fun productRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient())
        .build()

    private fun httpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()


    class HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
                .newBuilder()
                .build()
            return chain.proceed(request)
        }
    }


    fun getApi(): ProductDataSource = getApiService()

    inline fun <reified T> getApiService(): T {
        return  retrofitProduct.create(T::class.java)
    }
