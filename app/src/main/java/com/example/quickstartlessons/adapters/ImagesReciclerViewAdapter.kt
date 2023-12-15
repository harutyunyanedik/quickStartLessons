package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemReciclerViewBinding

class ImagesRecyclerViewAdapter : RecyclerView.Adapter<ImagesRecyclerViewAdapter.BaseViewHolder>() {

    private val item: MutableList<Model> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ImagesRecyclerViewHolder(ItemReciclerViewBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<Model>?) {
        this.item.clear()
        item?.let {
            this.item.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: Model)
    }

    inner class ImagesRecyclerViewHolder(private val binding: ItemReciclerViewBinding) : BaseViewHolder(binding.root) {

        override fun bind(item: Model) {
            binding.title.text = item.title
            Glide.with(context).load(item.imageUrl).into(binding.imageUrl)
        }
    }
}
