package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.quickstartlessons.databinding.ItemRecycleViewBinding

class AdapterImageRecyclerView : RecyclerView.Adapter<AdapterImageRecyclerView.ImageViewHolder>() {
    val items: MutableList<ImageModel> = mutableListOf()
    lateinit var context: Context
    lateinit var inflater: LayoutInflater


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemRecycleViewBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<ImageModel>?) {
        items.clear()
        item?.let {
            items.addAll(item)
            notifyDataSetChanged()
        }
    }

    inner class ImageViewHolder(private val item: ItemRecycleViewBinding) :
        RecyclerView.ViewHolder(item.root) {
        fun bind(binding: ImageModel) {
            Glide.with(context).load(binding.imageModel).into(item.imageItem)
        }
    }
}
data class ImageModel(val imageModel:String)