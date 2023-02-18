package com.example.bottomnavigationapi.di

import com.example.bottomnavigationapi.data.remote.client.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideEverythingApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideEverythingApiService()

    @Singleton
    @Provides
    fun provideSourcesApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideSourcesApiService()

    @Singleton
    @Provides
    fun provideTopHeadlinesApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideTopHeadlinesApiService()

}