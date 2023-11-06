package com.example.quickstartlessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FavoriteItemBinding

class FavoriteItemsAdapter: RecyclerView.Adapter<FavoriteItemsAdapter.FavoriteItemViewHolder>() {

    val list = mutableListOf<String>()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteItemViewHolder {
        return FavoriteItemViewHolder(FavoriteItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addList(list: List<String>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class FavoriteItemViewHolder(val view: FavoriteItemBinding): RecyclerView.ViewHolder(view.root){
        fun bind(position: Int) {
            view.textViewTitle.text = list[position]
        }
    }
}