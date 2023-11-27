package com.example.quickstartlessons.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.android.models.ModelOne
import com.example.quickstartlessons.databinding.FirsyRecyclerViewBinding

class NewsAdapterAdapter : RecyclerView.Adapter<NewsAdapterAdapter.NewsViewHolder>() {
    lateinit var inflater: LayoutInflater
    lateinit var context: Context
    private val item: MutableList<ModelOne> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(FirsyRecyclerViewBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = item.size

    fun updateData(event: List<ModelOne>?) {
        this.item.clear()
        event?.let {
            item.addAll(event)
        }
    }

    inner class NewsViewHolder(private val binding: FirsyRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ModelOne) {
            binding.iconText.text = item.text
            Glide.with(context).load(item.image).into(binding.icon)
        }
    }
}
