package com.example.bottomnavigationapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.youtube.databinding.ItemSourceBinding

class SourceAdapter : ListAdapter<ArticlesItem, SourceAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemSourceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ArticlesItem) {
            Glide.with(binding.ivSource.context)
                .load(item.urlToImage)
                .into(binding.ivSource)
            binding.tvSourceTitle.text = item.title
            binding.tvSourceDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSourceBinding.inflate(
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