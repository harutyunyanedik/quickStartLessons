package com.example.quickstartlessons.module.product.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.module.product.data.model.response.ProductDto
import com.example.quickstartlessons.databinding.FragmentProductDataBinding


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items: MutableList<ProductDto> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(FragmentProductDataBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<ProductDto>?) {
        items.clear()
        item?.let {
            items.addAll(item)
        }
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(private val binding: FragmentProductDataBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.favoriteProduct.setOnCheckedChangeListener { button, isChecked ->
               if (button.isPressed) {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        items[adapterPosition].favorite = isChecked

                    }
                }
            }
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: ProductDto) {
            Glide.with(context).load(item.thumbnail).into(binding.imageProduct)
            binding.productBrand.text = item.brand
            binding.productPrice.text = "${item.price} $"
            binding.productTitle.text = item.title
            binding.productDescription.text = item.description
            binding.favoriteProduct.isChecked=item.favorite
        }
    }
}