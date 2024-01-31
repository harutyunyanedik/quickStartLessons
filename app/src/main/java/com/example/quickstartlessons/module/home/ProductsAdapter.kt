package com.example.quickstartlessons.module.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ProductItemBinding
import com.example.quickstartlessons.module.product.data.model.Product

class ProductsAdapter(val onClickItem: (Product) -> Unit,
                      val favoriteUpdate: (Boolean, Product) -> Unit
): RecyclerView.Adapter<ProductsAdapter.BaseViewHolder>()
{

    private val items = mutableListOf<Product>()
    private val favoriteItems = mutableListOf<Int>()
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

    @SuppressLint("NotifyDataSetChanged")
    fun updateFavorites(list: List<Int>?) {
        favoriteItems.clear()
        list?.let {
            favoriteItems.addAll(list)
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
                    if (buttonView.isPressed){
                        favoriteUpdate.invoke(isChecked, items[adapterPosition])
                    }
                }
            }
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION){
                    onClickItem.invoke(items[adapterPosition])
                }
            }
        }

        override fun bind(item: Product) {
            Glide.with(context).load(item.imageUrl).into(binding.imageViewProduct)
            binding.tvTitle.text = item.title
            binding.tvPrice.text = "${item.price} $"
            binding.checkboxFavorite.isChecked = favoriteItems.contains(item.id)

        }
    }
}