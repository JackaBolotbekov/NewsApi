package com.example.bottomnavigationapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.youtube.databinding.ItemEverythingBinding

class EverythingAdapter : ListAdapter<ArticlesItem, EverythingAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemEverythingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ArticlesItem) = with(binding) {
            Glide.with(ivEverything.context).load(item.urlToImage).into(ivEverything)
            tvEverythingTitle.text = item.title
            tvEverythingDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEverythingBinding.inflate(
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