package com.example.bottomnavigationapi.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.bottomnavigationapi.base.BaseRepository
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.remote.apiservices.EverythingApiService
import com.example.bottomnavigationapi.data.remote.pagingsources.EverythingPagingSources
import javax.inject.Inject

class EverythingRepository @Inject constructor(private val service: EverythingApiService) :
    BaseRepository() {

    fun fetchBitcoinById(): LiveData<PagingData<ArticlesItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                EverythingPagingSources(service)
            }, initialKey = 1
        ).liveData
    }
}