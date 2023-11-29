package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.FragmentFirstPageImageBinding
import com.example.quickstartlessons.android.model.RvModelImage


class AdapterFirstImageView : RecyclerView.Adapter<AdapterFirstImageView.FirstImageViewHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items = mutableListOf<RvModelImage>()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<RvModelImage>?) {
        items.clear()
        item?.let {
            items.addAll(item)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstImageViewHolder {
        return FirstImageViewHolder(FragmentFirstPageImageBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FirstImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class FirstImageViewHolder(private val binding: FragmentFirstPageImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RvModelImage) {
            Glide.with(binding.Image).load(item.image).into(binding.Image)
        }
    }
}