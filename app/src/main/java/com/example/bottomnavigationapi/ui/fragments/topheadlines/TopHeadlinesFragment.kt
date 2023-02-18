package com.example.bottomnavigationapi.ui.fragments.topheadlines

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bottomnavigationapi.base.BaseFragment
import com.example.bottomnavigationapi.ui.adapters.TopHeadlinesAdapter
import com.example.bottomnavigationapi.utils.Resource
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
        viewModel.fetchTopHeadlinesBiId("us").observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    it.data?.let {
                        topHeadlinesAdapter.submitList(it.articles)
                    }
                }
            }
        }
    }
}