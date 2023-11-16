package com.example.quickstartlessons.android

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ImageReciclerViewBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ImagesHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val images: MutableList<Model> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesAdapter.ImagesHolder {
        return ImagesHolder(ImageReciclerViewBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ImagesAdapter.ImagesHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(images: List<Model>) {
        //this.images.clear()
        this.images.addAll(images)
        notifyDataSetChanged()
    }

    inner class ImagesHolder(private val binding: ImageReciclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(images: Model) {
            binding.imagePhotos.setImageResource(images.images)
        }
    }
}