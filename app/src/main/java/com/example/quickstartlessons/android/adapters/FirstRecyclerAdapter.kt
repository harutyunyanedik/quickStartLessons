package com.example.quickstartlessons.android.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.models.RvModel
import com.example.quickstartlessons.databinding.ItemRecyclerViewBinding

class FirstRecyclerAdapter : RecyclerView.Adapter<FirstRecyclerAdapter.FirstRecyclerViewHolder>() {

    lateinit var inflater: LayoutInflater
    lateinit var context: Context

    private val items: MutableList<RvModel> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstRecyclerViewHolder {
        return FirstRecyclerViewHolder(ItemRecyclerViewBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: FirstRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<RvModel>?) {
        this.items.clear()
        items?.let {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    inner class FirstRecyclerViewHolder(private val binding: ItemRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RvModel) {
            binding.titleTextView.text = item.title
            binding.descriptionTextView.text = item.description
        }
    }
}