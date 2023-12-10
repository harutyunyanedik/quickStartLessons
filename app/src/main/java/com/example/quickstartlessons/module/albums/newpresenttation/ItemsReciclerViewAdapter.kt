package com.example.quickstartlessons.module.albums.newpresenttation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemsRecyclerViewBinding

class ItemsRecyclerViewAdapter : RecyclerView.Adapter<ItemsRecyclerViewAdapter.ItemsRecyclerViewHolder>() {

    private val item: MutableList<Model> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsRecyclerViewHolder {
        return ItemsRecyclerViewHolder(ItemsRecyclerViewBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ItemsRecyclerViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size

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

    inner class ItemsRecyclerViewHolder(private val binding: ItemsRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Model) {
            binding.title.text = item.title
            binding.massage.text = item.massage
        }
    }
}
