package com.example.bottomnavigationapi.ui.fragments.everything

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.bottomnavigationapi.base.BaseViewModel
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(private val everythingRepository: EverythingRepository) :
    BaseViewModel() {

    fun fetchEverythingBiId(): LiveData<PagingData<ArticlesItem>> {
        return everythingRepository.fetchBitcoinById().cachedIn(viewModelScope)
    }
}