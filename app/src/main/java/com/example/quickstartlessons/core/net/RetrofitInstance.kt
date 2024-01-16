package com.example.quickstartlessons.core.net

import com.example.quickstartlessons.core.net.products.datasource.ProductDataSource
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val baseUrl = "https://dummyjson.com/products"

val retrofit by lazy { provideRetrofit() }


private fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .client(provideHttpClient())
    .build()

private fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(60, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .addInterceptor(HeaderInterceptor())
    .build()


class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("api-key", "a7f6a48e-5e8c-49f7-a822-5e439a477071")
            .build()
        return chain.proceed(request)
    }
}

fun getApi(): ProductDataSource = getApiService()

inline fun <reified T> getApiService(): T {
    return retrofit.create(T::class.java)
}