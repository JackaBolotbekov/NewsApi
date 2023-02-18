package com.example.bottomnavigationapi.data.remote.apiservices

import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.models.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService{

    @GET("everything")
    suspend fun fetchTopHeadlines(
        @Query("q") q: String,
        @Query("page") page: Int = 1
    ): Response<ArticlesItem>
}