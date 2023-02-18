package com.example.bottomnavigationapi.data.remote.client

import com.example.bottomnavigationapi.data.remote.apiservices.EverythingApiService
import com.example.bottomnavigationapi.data.remote.apiservices.SourcesApiService
import com.example.bottomnavigationapi.data.remote.apiservices.TopHeadlinesApiService
import com.example.bottomnavigationapi.data.remote.interseptor.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(ApiKeyInterceptor())
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideEverythingApiService(): EverythingApiService =
        retrofitClient.create(EverythingApiService::class.java)

    fun provideSourcesApiService(): SourcesApiService =
        retrofitClient.create(SourcesApiService::class.java)

    fun provideTopHeadlinesApiService(): TopHeadlinesApiService = retrofitClient.create(
        TopHeadlinesApiService::class.java
    )
}