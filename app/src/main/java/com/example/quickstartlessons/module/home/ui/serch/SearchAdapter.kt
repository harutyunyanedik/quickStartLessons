package com.example.quickstartlessons.module.home.ui.serch

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.quickstartlessons.databinding.ItemSearchProductBinding
import com.example.quickstartlessons.module.product.data.model.response.ProductDto

class SearchAdapter:RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    private val items: MutableList<ProductDto> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
       return SearchViewHolder(ItemSearchProductBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount(): Int=items.size


    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
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


    inner class SearchViewHolder (private val binding: ItemSearchProductBinding):RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(item: ProductDto) {
            Glide.with(context).load(item.thumbnail).into(binding.imageProduct)
            binding.productBrand.text = item.brand
            binding.productPrice.text = "${item.price} $"
            binding.productTitle.text = item.title
            binding.productDescription.text = item.description
            //binding.favoriteProduct.isChecked = favoriteItems.contains(item.id)
        }
    }
}