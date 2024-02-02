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

class ProductsAdapter(
    val onClickItem: (ProductDto) -> Unit,
    val updateFavorite: (Boolean, ProductDto) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.BaseViewHolder>() {
    private val items = mutableListOf<ProductDto>()
    private val favoriteItems = mutableListOf<Int>()
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
            items.addAll(list)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateFavorites(list: List<Int>?) {
        favoriteItems.clear()
        list?.let {
            favoriteItems.addAll(list)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: ProductDto)
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) : BaseViewHolder(binding.root) {
        init {
            binding.favoriteCheckbox.setOnCheckedChangeListener { button, isChecked ->
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    if (button.isPressed) {
                        updateFavorite.invoke(isChecked, items[adapterPosition])
                    }
                }
            }

            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onClickItem.invoke(items[adapterPosition])
                }
            }
        }

        @SuppressLint("SetTextI18n")
        override fun bind(item: ProductDto) {
            Glide.with(context).load(item.imageUrl).into(binding.imageViewProduct)
            binding.productDescription.text = item.title
            binding.priceTextView.text = "${item.price} $"
            binding.favoriteCheckbox.isChecked = favoriteItems.contains(item.id)
        }
    }
}