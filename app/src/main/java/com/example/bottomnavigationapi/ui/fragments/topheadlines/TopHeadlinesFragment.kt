package com.example.bottomnavigationapi.ui.fragments.topheadlines

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bottomnavigationapi.base.BaseFragment
import com.example.bottomnavigationapi.ui.adapters.TopHeadlinesAdapter
import com.example.youtube.R
import com.example.youtube.databinding.FragmentTopHeadlinesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopHeadlinesFragment :
    BaseFragment<FragmentTopHeadlinesBinding, TopHeadlinesViewModel>(R.layout.fragment_top_headlines) {

    override val binding: FragmentTopHeadlinesBinding by viewBinding(FragmentTopHeadlinesBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()
    private val topHeadlinesAdapter = TopHeadlinesAdapter()

    override fun setupListeners() = with(binding.recyclerViewHeadlines) {
        adapter = topHeadlinesAdapter
    }

    override fun setupSubscribes() {
        subscribeToBitcoinById()
    }

    private fun subscribeToBitcoinById() {
        viewModel.fetchTopHeadlinesBiId().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                topHeadlinesAdapter.submitData(it)
            }
        }
    }
}