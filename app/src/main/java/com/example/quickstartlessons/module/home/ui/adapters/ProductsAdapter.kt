package com.example.quickstartlessons.module.home.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.module.products.data.ProductDto
import com.example.quickstartlessons.databinding.ItemProductBinding

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.BaseViewHolder>() {
    private val items = mutableListOf<ProductDto>()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ProductViewHolder(ItemProductBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<ProductDto>?) {
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: ProductDto)
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) : BaseViewHolder(binding.root) {
        init {
            binding.checkboxFavorite.setOnCheckedChangeListener { button, isChecked ->
                if (button.isPressed) {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        items[adapterPosition].isFavorite = isChecked
                    }
                }
            }
        }
        @SuppressLint("SetTextI18n")
        override fun bind(item: ProductDto) {
            Glide.with(context).load(item.imageUrl).into(binding.imageViewProduct)
            binding.productDescription.text = item.title
            binding.productPrice.text = "${item.price} $"
            binding.checkboxFavorite.isChecked = item.isFavorite
        }
    }
}