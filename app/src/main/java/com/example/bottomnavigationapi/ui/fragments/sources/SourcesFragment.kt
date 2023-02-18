package com.example.bottomnavigationapi.ui.fragments.sources

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bottomnavigationapi.base.BaseFragment
import com.example.bottomnavigationapi.ui.adapters.SourceAdapter
import com.example.bottomnavigationapi.utils.Resource
import com.example.youtube.R
import com.example.youtube.databinding.FragmentSourcesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SourcesFragment :
    BaseFragment<FragmentSourcesBinding, SourcesViewModel>(R.layout.fragment_sources) {

    override val binding: FragmentSourcesBinding by viewBinding(FragmentSourcesBinding::bind)
    override val viewModel: SourcesViewModel by viewModels()
    private val sourceAdapter = SourceAdapter()

    override fun setupListeners() = with(binding.recyclerViewSources) {
        adapter = sourceAdapter
    }

    override fun setupSubscribes() {
        subscribeToBitcoinById()
    }

    private fun subscribeToBitcoinById() {
        viewModel.fetchSourcesBiId("news").observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    it.data?.let {
                        sourceAdapter.submitList(it.articles)
                    }
                }
            }
        }
    }
}