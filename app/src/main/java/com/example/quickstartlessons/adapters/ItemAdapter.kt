package com.example.quickstartlessons.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemTextBinding
import com.example.quickstartlessons.models.ItemModel

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var item = mutableListOf<ItemModel>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemTextBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(item[position])
    }

    fun updateAdapter(items: List<ItemModel>?) {
        this.item.clear()
        items?.let {
            this.item.addAll(it)
        }

    }

    inner class ItemViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: ItemModel) {
            binding.itemText.text = items.title
        }
    }


}