package com.example.bottomnavigationapi.ui.fragments.sources

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.bottomnavigationapi.base.BaseViewModel
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.repositories.EverythingRepository
import com.example.bottomnavigationapi.data.repositories.SourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(private val everythingRepository: EverythingRepository) :
    BaseViewModel() {

    fun fetchSourcesBiId(q: String) = everythingRepository.fetchBitcoinById(q)
}