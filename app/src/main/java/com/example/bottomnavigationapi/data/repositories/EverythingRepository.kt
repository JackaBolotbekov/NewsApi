package com.example.bottomnavigationapi.data.repositories

import com.example.bottomnavigationapi.base.BaseRepository
import com.example.bottomnavigationapi.data.remote.apiservices.EverythingApiService
import javax.inject.Inject

class EverythingRepository @Inject constructor(private val service: EverythingApiService) :
    BaseRepository() {

    fun fetchBitcoinById(q : String) = doRequest {
        service.fetchBitcoin(q)
    }
}