package com.example.quickstartlessons.module.details

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ImageItemBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {
    private val items = mutableListOf<String>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<String>?) {
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    inner class ImageViewHolder(private val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            Glide.with(context).load(item).into(binding.imageViewProductDetails)
        }
    }
}