package com.example.bottomnavigationapi.data.repositories

import com.example.bottomnavigationapi.base.BaseRepository
import com.example.bottomnavigationapi.data.remote.apiservices.SourcesApiService
import javax.inject.Inject

class SourceRepository @Inject constructor(private val service: SourcesApiService) :
    BaseRepository() {

    fun fetchBitcoinById(q : String) = doRequest {
        service.fetchSources(q)
    }
}