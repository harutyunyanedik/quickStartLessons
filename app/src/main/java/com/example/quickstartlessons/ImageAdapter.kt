package com.example.quickstartlessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ImageLayoutBinding

class ImageAdapter(mainActivity: MainActivity, createList: List<ImageModel>) : RecyclerView.Adapter<ImageAdapter.ImageRecyclerViewHolder>() {

    private val items: MutableList<ImageModel> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageRecyclerViewHolder =
        ImageRecyclerViewHolder(ImageLayoutBinding.inflate(inflater, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ImageRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }


    fun updateData(items: List<ImageModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()

    }

    inner class ImageRecyclerViewHolder(private val binding: ImageLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: ImageModel) {
            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.image1)
            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.image2)

        }
    }


}