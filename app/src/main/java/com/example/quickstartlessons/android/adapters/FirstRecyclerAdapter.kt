package com.example.quickstartlessons.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.models.RvModels
import com.example.quickstartlessons.databinding.ItemRecyclarViewBinding

class FirstRecyclerAdapter : RecyclerView.Adapter<FirstRecyclerAdapter.FirstRecyclerViewHolder>(){

    lateinit var inflater:LayoutInflater
    lateinit var context:Context

    private val items:MutableList<RvModels> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstRecyclerViewHolder {
     return FirstRecyclerViewHolder(ItemRecyclarViewBinding.inflate(inflater, parent,false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FirstRecyclerViewHolder, position: Int) {
holder.bind(items[position])
    }

  fun updateData(items:List<RvModels>?){
        this.items.clear()
       items?.let{
           this.items.addAll(items)
       }
        notifyDataSetChanged()
    }

    inner class FirstRecyclerViewHolder(private val binding:ItemRecyclarViewBinding):RecyclerView.ViewHolder(binding.root){

         fun bind(items: RvModels){
            binding.titleTextView.text=items.title
            binding.descriptionTextView.text=items.description
        }
    }
}