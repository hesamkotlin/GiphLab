package com.example.giphlab.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.giphlab.R
import com.example.giphlab.databinding.ItemGifBinding
import com.example.giphlab.shared.model.GifModel

class GifAdapter: ListAdapter<GifModel, GifAdapter.GifViewHolder>(
    object : DiffUtil.ItemCallback<GifModel>() {
        override fun areItemsTheSame(oldItem: GifModel, newItem: GifModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GifModel, newItem: GifModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }

) {

    inner class GifViewHolder(
        private val binding: ItemGifBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(gifModel: GifModel) {
            binding.model = gifModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val binding = DataBindingUtil.inflate<ItemGifBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_gif,
            parent,
            false
        )
        return GifViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.count()
    }

}
