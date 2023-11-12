package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.Models
import com.example.quickstartlessons.databinding.ItemReciclerViewBinding

class AdapterRecyclerView (private val onItemClick:(Int)->Unit): RecyclerView.Adapter<AdapterRecyclerView.AdapterRecyclerViewHolder>() {
    private lateinit var inflater: LayoutInflater
     private lateinit var context: Context
    private val items: MutableList<Models> = mutableListOf()
    override fun onAttachedToRecyclerView(arsenalFCSpecials: RecyclerView) {
        super.onAttachedToRecyclerView(arsenalFCSpecials)
        context = arsenalFCSpecials.context
        inflater = LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecyclerViewHolder {
        return AdapterRecyclerViewHolder(ItemReciclerViewBinding.inflate(inflater, parent, false))
    }
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: AdapterRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<Models>?) {
        this.items.clear()
        items?.let {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }
    inner class AdapterRecyclerViewHolder(private val binding: ItemReciclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.imageUnchecked.setOnCheckedChangeListener { button, isChecked: Boolean ->
                if (button.isPressed) {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        items[adapterPosition].isFavorite = isChecked
                    }
                }
            }
            binding.rootLayout.setOnClickListener{
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        items[adapterPosition].isExpanded = items[adapterPosition].isExpanded
                      onItemClick.invoke(adapterPosition)
                        notifyItemChanged(adapterPosition)
                    }
            }
        }
        fun bind(model: Models) {
            binding.textView.text = model.title
            binding.imageUnchecked.isChecked= model.isFavorite
            binding.expendedImage.isVisible=model.isExpanded
        }
    }
}