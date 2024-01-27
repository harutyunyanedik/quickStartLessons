package com.example.quickstartlessons.module.products.details

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemProductDetaislBinding
import com.example.quickstartlessons.module.products.data.ProductDto

class ProductDetailsAdapter : RecyclerView.Adapter<ProductDetailsAdapter.BaseViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var items = mutableListOf<ProductDto>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ProductDetailsBaseViewHolder(ItemProductDetaislBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: ProductDto)

    }

    @SuppressLint("NotifyDataSetChanged")
     fun updateDataDetails(item: ProductDto) {
        items.clear()
        item.let {
            items.addAll(items)
        }
        notifyDataSetChanged()
    }

    inner class ProductDetailsBaseViewHolder(private val binding: ItemProductDetaislBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: ProductDto) {
            Glide.with(context).load(item.imageUrl).into(binding.productImage)
            binding.productTitle.text = item.title
            binding.productDetailedDescription.text = item.description
            binding.productPrice.text = item.price.toString()
            binding.checkboxFavorite.isChecked = item.isFavorite
        }

    }

}