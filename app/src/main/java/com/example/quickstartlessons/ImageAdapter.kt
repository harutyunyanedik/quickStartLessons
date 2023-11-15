package com.example.quickstartlessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ImageItemBinding


class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageRecyclerViewHolder>() {

    private val items = mutableListOf<ImageModel>()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageRecyclerViewHolder {
        return ImageRecyclerViewHolder(ImageItemBinding.inflate(inflater))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ImageRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }


    fun updateData(items: List<ImageModel>) {
        this.items.clear()
        items.let {
            this.items.addAll(it)
        }
    }

    inner class ImageRecyclerViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageModel) {
            Glide.with(binding.image)
                .load(item.imageUrl)
                .into(binding.image)
        }
    }
}