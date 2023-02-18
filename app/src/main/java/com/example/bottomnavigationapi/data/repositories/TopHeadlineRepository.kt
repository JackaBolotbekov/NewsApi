package com.example.bottomnavigationapi.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.bottomnavigationapi.base.BaseRepository
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.remote.apiservices.TopHeadlinesApiService
import com.example.bottomnavigationapi.data.remote.pagingsources.TopHeadlinesPagingSources
import javax.inject.Inject

class TopHeadlineRepository @Inject constructor(private val service: TopHeadlinesApiService) :
    BaseRepository() {

    fun fetchTopHeadlinesById(): LiveData<PagingData<ArticlesItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                TopHeadlinesPagingSources(service)
            }, initialKey = 1
        ).liveData
    }
}