package com.example.bottomnavigationapi.ui.fragments.topheadlines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.bottomnavigationapi.base.BaseViewModel
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.repositories.SourceRepository
import com.example.bottomnavigationapi.data.repositories.TopHeadlineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(private val topHeadlinesRepository: TopHeadlineRepository) :
    BaseViewModel() {

    fun fetchTopHeadlinesBiId(): LiveData<PagingData<ArticlesItem>> {
        return topHeadlinesRepository.fetchTopHeadlinesById().cachedIn(viewModelScope)
    }
}