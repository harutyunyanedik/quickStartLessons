package com.example.quickstartlessons.module.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ProductItemBinding
import com.example.quickstartlessons.module.data.Product

class ProductsAdapter: RecyclerView.Adapter<ProductsAdapter.BaseViewHolder>() {

    private val items = mutableListOf<Product>()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ProductViewHolder(ProductItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<Product>?) {
        items.clear()
        list?.let {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Product)
    }
    inner class ProductViewHolder(private val binding: ProductItemBinding): BaseViewHolder(binding.root) {

        init {
            binding.checkboxFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
                if (adapterPosition != RecyclerView.NO_POSITION){
                    items[adapterPosition].isFavorite = isChecked
                }
            }
        }

        override fun bind(item: Product) {
            Glide.with(context).load(item.imageUrl).into(binding.imageViewProduct)
            binding.tvTitle.text = item.title
            binding.tvPrice.text = "${item.price.toString()} $"

        }
    }
}