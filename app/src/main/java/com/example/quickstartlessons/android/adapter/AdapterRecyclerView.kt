package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.Models
import com.example.quickstartlessons.databinding.ItemReciclerViewBinding


class AdapterRecyclerView : RecyclerView.Adapter<AdapterRecyclerView.AdapterRecyclerViewHolder>() {
 private lateinit var inflater:LayoutInflater
 private lateinit var context:Context

    override fun onAttachedToRecyclerView(arsenalFCSpecials: RecyclerView) {
        super.onAttachedToRecyclerView(arsenalFCSpecials)
        context = arsenalFCSpecials.context
        inflater = LayoutInflater.from(context)
    }
 private val items:MutableList<Models> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecyclerViewHolder {
       return AdapterRecyclerViewHolder(ItemReciclerViewBinding.inflate(inflater, parent,false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AdapterRecyclerViewHolder, position: Int) {
       holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items:List<Models>?){
        this.items.clear()
        items?.let {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    inner class AdapterRecyclerViewHolder(private val binding: ItemReciclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Models) {
     binding.textView.text = items.title
        }
    }
}