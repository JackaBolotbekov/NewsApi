package com.example.bottomnavigationapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.youtube.databinding.ItemTopHeadlinesBinding

class TopHeadlinesAdapter : ListAdapter<ArticlesItem, TopHeadlinesAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemTopHeadlinesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ArticlesItem) {
            Glide.with(binding.ivTopheadlines.context)
                .load(item.urlToImage)
                .into(binding.ivTopheadlines)
            binding.tvTopheadlineTitle.text = item.title
            binding.tvTopheadlinesDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTopHeadlinesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ArticlesItem>() {
            override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem.source.name == newItem.source.name
            }

            override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}