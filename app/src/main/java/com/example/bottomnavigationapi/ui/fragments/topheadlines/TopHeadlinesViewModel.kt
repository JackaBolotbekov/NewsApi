package com.example.bottomnavigationapi.ui.fragments.topheadlines

import com.example.bottomnavigationapi.base.BaseViewModel
import com.example.bottomnavigationapi.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(private val everythingRepository: EverythingRepository) :
    BaseViewModel() {

    fun fetchTopHeadlinesBiId(q: String) = everythingRepository.fetchBitcoinById(q)
}