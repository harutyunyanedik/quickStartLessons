package com.example.quickstartlessons.module.albums.popuphomework.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemDetailedBinding
import com.example.quickstartlessons.module.albums.popuphomework.data.ItemsData

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.BaseViewHolder>() {

    private val items = mutableListOf<ItemsData>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemsViewHolder(ItemDetailedBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: ItemsData)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(list: List<ItemsData>) {
        items.clear()
        list?.let {
            items.addAll(items)
        }
        notifyDataSetChanged()
    }

    inner class ItemsViewHolder(private val binding: ItemDetailedBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: ItemsData) {
            binding.nameTitle1.text = item.name
            binding.surnameTitle1.text = item.surname
            binding.countryTitle1.text = item.country
        }


    }
}