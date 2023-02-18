package com.example.bottomnavigationapi.ui.fragments.everything

import com.example.bottomnavigationapi.base.BaseViewModel
import com.example.bottomnavigationapi.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(private val everythingRepository: EverythingRepository) :
    BaseViewModel() {

    fun fetchEverythingBiId(q : String) = everythingRepository.fetchBitcoinById(q)
}