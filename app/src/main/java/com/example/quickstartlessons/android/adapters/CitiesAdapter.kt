package com.example.quickstartlessons.android.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.models.CitiesModel
import com.example.quickstartlessons.databinding.ItemRvDescriptionBinding
import com.example.quickstartlessons.databinding.ItemRvEventsBinding
import com.example.quickstartlessons.databinding.ItemRvHeaderBinding

class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.BaseViewHolder>() {
    private val items: MutableList<CitiesModel> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> CityViewHolder(ItemRvHeaderBinding.inflate(inflater, parent, false))
            1 -> EventViewHolder(ItemRvEventsBinding.inflate(inflater, parent, false))
            else -> DescriptionViewHolder(ItemRvDescriptionBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].city == null && items[position].title == null) {
            2
        } else if (items[position].city == null && items[position].description == null) {
            1
        } else {
            0
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: MutableList<CitiesModel>) {
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        inflater = LayoutInflater.from(recyclerView.context)
        context = recyclerView.context
    }


    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view.rootView) {
        abstract fun bind(item: CitiesModel)
    }


    inner class CityViewHolder(private val binding: ItemRvHeaderBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: CitiesModel) {
            binding.headerText.text = item.city
        }

    }

    inner class EventViewHolder(private val binding: ItemRvEventsBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: CitiesModel) {
            binding.standardText.text = item.title
        }

    }

    inner class DescriptionViewHolder(private val binding: ItemRvDescriptionBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: CitiesModel) {
            binding.eventsDesc.text = item.description
        }
    }
}