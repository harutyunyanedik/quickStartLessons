package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemCountryBinding
import com.example.quickstartlessons.models.CountryModel

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private val items: MutableList<CountryModel> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder = CountryViewHolder(ItemCountryBinding.inflate(inflater, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<CountryModel>?) {
        this.items.clear()
        this.items.addAll(items ?: emptyList())
        notifyDataSetChanged()

    }

    inner class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        private val childAdapter: ChildAdapter = ChildAdapter()

        init {
            binding.subItem.adapter = childAdapter
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    items[adapterPosition].isExpanded = !items[adapterPosition].isExpanded
                    notifyItemChanged(adapterPosition)
                }
            }
        }

        fun bind(item: CountryModel) {
            binding.countryName.text = item.title
            Glide.with(context).load(item.image).into(binding.flagImage)
            childAdapter.updateData(item.childItemList)
            val rotation = if (item.isExpanded) 180f else 0f
            binding.arrowDownImage.rotation = rotation
            binding.subItem.isVisible = item.isExpanded

        }
    }
}