package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemNewsBinding
import com.example.quickstartlessons.models.NewsModel

class NewsAdapter(val onItemClick: (NewsModel) -> Unit, val onSharedClick: (NewsModel) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items = mutableListOf<NewsModel>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ItemNewsBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(list: List<NewsModel>?) {
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick.invoke(items[adapterPosition])
                }
            }
            binding.imageViewShare.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onSharedClick.invoke(items[adapterPosition])
                }
            }
        }

        fun bind(item: NewsModel) {
            with(binding) {
                textViewTitle.text = item.title
                textViewData.text = item.data
                Glide.with(context).load(item.imageUrl).into(imageViewNews)
            }
        }
    }
}