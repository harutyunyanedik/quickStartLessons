package com.example.quickstartlessons.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ChildItemBinding
import com.example.quickstartlessons.models.ImageModel

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var items = mutableListOf<ImageModel>()
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ChildItemBinding.inflate(inflater))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ImageViewHolder(private val binding: ChildItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageModel) {
            Glide.with(binding.images).load(item.imageUrl).into(binding.images)

        }

    }
}