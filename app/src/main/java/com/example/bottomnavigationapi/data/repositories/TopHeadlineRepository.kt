package com.example.bottomnavigationapi.data.repositories

import com.example.bottomnavigationapi.base.BaseRepository
import com.example.bottomnavigationapi.data.remote.apiservices.TopHeadlinesApiService
import javax.inject.Inject

class TopHeadlineRepository @Inject constructor(private val service: TopHeadlinesApiService) :
    BaseRepository() {

    fun fetchBitcoinById(q : String) = doRequest {
        service.fetchTopHeadlines(q)
    }
}