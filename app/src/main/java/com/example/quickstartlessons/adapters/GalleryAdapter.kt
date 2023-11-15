package com.example.quickstartlessons.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemImageBinding
import com.example.quickstartlessons.models.ImageModel

class GalleryAdapter: RecyclerView.Adapter<GalleryAdapter.ImageGalleryViewHolder>() {

    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items = mutableListOf<ImageModel>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageGalleryViewHolder {
        return ImageGalleryViewHolder(ItemImageBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: ImageGalleryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateAdapter(items: List<ImageModel>?){
        this.items.clear()
        items?.let {
            this.items.addAll(it)
        }
    }

    inner class ImageGalleryViewHolder(private val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: ImageModel){
            Glide.with(binding.imageViewPicture).load(item.imageUrl).into(binding.imageViewPicture)
        }
    }
}