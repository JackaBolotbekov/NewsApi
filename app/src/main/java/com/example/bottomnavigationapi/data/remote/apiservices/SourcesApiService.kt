package com.example.bottomnavigationapi.data.remote.apiservices

import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.models.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SourcesApiService{

    @GET("top-headlines/source")
    suspend fun fetchSources(
        @Query("q") q: String,
    ): Response<ArticlesItem>
}