package com.example.bottomnavigationapi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import com.example.bottomnavigationapi.data.remote.client.RetrofitClient

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