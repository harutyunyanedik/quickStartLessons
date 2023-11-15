package com.example.quickstartlessons.android

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.CountryItemBinding

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryHolder>() {
    private val itemList: MutableList<CountryModel> = mutableListOf()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        return CountryHolder(CountryItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.bind(itemList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(itemList: List<CountryModel>?) {
        this.itemList.clear()
        this.itemList.addAll(itemList ?: emptyList())
        notifyDataSetChanged()
    }

    inner class CountryHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: CountryModel) {
            for (i in 1..3) {
                Glide.with(context).load(model.img).into(binding.country)
            }
        }
    }
}