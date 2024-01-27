package com.example.quickstartlessons.module.description.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.RvDescriptionFragmentBinding

class DescriptionsImagesRecyclerViewAdapter : RecyclerView.Adapter<DescriptionsImagesRecyclerViewAdapter.BaseViewHolder>() {

    private val items: MutableList<String> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return DescriptionsImagesRecyclerViewHolder(RvDescriptionFragmentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<String>?) {
        this.items.clear()
        item?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: String)
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class DescriptionsImagesRecyclerViewHolder(private val binding: RvDescriptionFragmentBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: String) {
            Glide.with(context).load(item).into(binding.images)
        }
    }
}




