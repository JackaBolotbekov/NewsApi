package com.example.bottomnavigationapi.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.bottomnavigationapi.base.BaseRepository
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.remote.apiservices.SourcesApiService
import com.example.bottomnavigationapi.data.remote.pagingsources.SourcesPagingSources
import javax.inject.Inject

class SourceRepository @Inject constructor(private val service: SourcesApiService) :
    BaseRepository() {

    fun fetchSourceById(): LiveData<PagingData<ArticlesItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                SourcesPagingSources(service)
            }, initialKey = 1
        ).liveData
    }
}