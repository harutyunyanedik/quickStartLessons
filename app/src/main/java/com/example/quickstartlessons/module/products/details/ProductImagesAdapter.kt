package com.example.quickstartlessons.module.products.details

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemProductImagesBinding

class ProductImagesAdapter : RecyclerView.Adapter<ProductImagesAdapter.BaseViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var items = mutableListOf<String>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
       return ProductImagesViewHolder(ItemProductImagesBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: String)
    }

    @SuppressLint("NotifyDataSetChanged")
     fun updateData(list: List<String>) {
        items.clear()
        list.let {
                items.addAll(list)
        }
        notifyDataSetChanged()
    }


    inner class ProductImagesViewHolder(private val binding: ItemProductImagesBinding) : BaseViewHolder(binding.root) {

        override fun bind(item: String) {
            Glide.with(context).load(item).into(binding.imageViewProductDetails)
        }
    }

}