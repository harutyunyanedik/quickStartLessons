package com.example.quickstartlessons.module.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.core.net.repo.model.ProductsDto
import com.example.quickstartlessons.databinding.RvHomeMainTabFragmentBinding

class ProductsRecyclerViewAdapter(private var onItemClick: (Boolean) -> Unit) : RecyclerView.Adapter<ProductsRecyclerViewAdapter.BaseViewHolder>() {

    private val item: MutableList<ProductsDto> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ProductsRecyclerViewHolder(RvHomeMainTabFragmentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<ProductsDto>?) {
        this.item.clear()
        item?.let {
            this.item.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: ProductsDto)
    }

    inner class ProductsRecyclerViewHolder(private val binding: RvHomeMainTabFragmentBinding) : BaseViewHolder(binding.root) {
        init {
            binding.favoriteCheckbox.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick.invoke(true)
                }
            }
        }

        override fun bind(item: ProductsDto) {
            binding.productId.text = item.id.toString()
            binding.productTitle.text = item.title
            binding.productBrand.text = item.brand
            binding.productCategory.text = item.category
            binding.productDescription.text = item.description
            binding.productPrice.text = item.description
            binding.productRating.text = item.rating
            Glide.with(context).load(item.thumbnail).into(binding.productThumbnail)
        }
    }

}
