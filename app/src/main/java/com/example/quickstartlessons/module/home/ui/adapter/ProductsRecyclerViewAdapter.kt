package com.example.quickstartlessons.module.home.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.module.settings.model.products.ProductsDto
import com.example.quickstartlessons.databinding.RvHomeMainTabFragmentBinding

class ProductsRecyclerViewAdapter(
    val onItemClick: (ProductsDto) -> Unit,
    val updateFavorites: (Boolean, ProductsDto) -> Unit
) :
    RecyclerView.Adapter<ProductsRecyclerViewAdapter.BaseViewHolder>() {

    private val items: MutableList<ProductsDto> = mutableListOf()
    private val favoriteItems = mutableListOf<Int>()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ProductsRecyclerViewHolder(RvHomeMainTabFragmentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<ProductsDto>?) {
        this.items.clear()
        item?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateFavorites(item: List<Int>?) {
        this.favoriteItems.clear()
        item?.let {
            this.favoriteItems.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: ProductsDto)
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class ProductsRecyclerViewHolder(private val binding: RvHomeMainTabFragmentBinding) : BaseViewHolder(binding.root) {
        init {
            binding.favoriteCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    if(buttonView.isPressed){
                        updateFavorites.invoke(isChecked,items[adapterPosition])
                    }
                }
            }
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick.invoke(items[adapterPosition])
                    notifyDataSetChanged()
                }
            }
        }

        @SuppressLint("SetTextI18n")
        override fun bind(item: ProductsDto) {
            binding.productId.text = item.id.toString()
            binding.productTitle.text = item.title
            binding.productPrice.text = "Price: ${item.price} $"
            binding.favoriteCheckbox.isChecked = favoriteItems.contains(item.id)
            Glide.with(context).load(item.thumbnail).into(binding.productThumbnail)
        }
    }

}
