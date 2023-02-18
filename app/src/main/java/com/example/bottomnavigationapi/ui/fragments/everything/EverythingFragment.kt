package com.example.bottomnavigationapi.ui.fragments.everything

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bottomnavigationapi.base.BaseFragment
import com.example.bottomnavigationapi.ui.adapters.EverythingAdapter
import com.example.youtube.R
import com.example.youtube.databinding.FragmentEverythingBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {

    override val binding: FragmentEverythingBinding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EverythingViewModel by viewModels()
    private val bitcoinAdapter = EverythingAdapter()

    override fun setupListeners() = with(binding.recyclerViewEverything) {
        adapter = bitcoinAdapter
    }

    override fun setupSubscribes() {
        subscribeToBitcoinById()
    }

    private fun subscribeToBitcoinById() {
        viewModel.fetchEverythingBiId().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                bitcoinAdapter.submitData(it)
            }
        }
    }
}