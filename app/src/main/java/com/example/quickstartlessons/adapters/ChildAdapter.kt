package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ChildItemBinding
import com.example.quickstartlessons.models.ChildModel

class ChildAdapter: RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {
    private val items: MutableList<ChildModel> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<ChildModel>?) {
        this.items.clear()
        items?.let {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(ChildItemBinding.inflate(inflater, parent, false))

    }

    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ChildViewHolder(private val binding: ChildItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.checkboxFavourite.setOnCheckedChangeListener { button, isChecked ->
                if (button.isPressed) {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        items[adapterPosition].isFavourite = isChecked
                        notifyItemChanged(adapterPosition)
                    }
                }
            }
        }

        fun bind(item: ChildModel) {
            binding.childTitle.text = item.title
            binding.checkboxFavourite.isChecked = item.isFavourite
        }
    }
}
