package com.example.quickstartlessons.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.ShopItem
import com.example.quickstartlessons.databinding.ItemShopBinding

class ShopItemAdapter : RecyclerView.Adapter<ShopItemAdapter.ShopItemViewHolder>() {

    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    private val shopItems = mutableListOf<ShopItem>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        return ShopItemViewHolder(ItemShopBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.bind(shopItems[position])
    }

    override fun getItemCount(): Int {
        return shopItems.size
    }

    fun updateData(list: List<ShopItem>?){
        shopItems.clear()
        list?.let {
            shopItems.addAll(it)
        }
        notifyDataSetChanged()

    }

    inner class ShopItemViewHolder(private val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(shopItem: ShopItem){
            binding.tvName.text = shopItem.name
            binding.tvCount.text = shopItem.count.toString()
        }

    }
}