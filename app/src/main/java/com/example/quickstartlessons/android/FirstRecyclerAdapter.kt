package com.example.quickstartlessons.android

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemRecyclerViewBinding
import com.example.quickstartlessons.models.RvModel

class FirstRecyclerAdapter : RecyclerView.Adapter<FirstRecyclerAdapter.FirstRecyclerViewHolder>() {
    lateinit var inFlater: LayoutInflater
    lateinit var context: Context
    private val items: MutableList<RvModel> = mutableListOf<RvModel>()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inFlater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstRecyclerViewHolder {
        return FirstRecyclerViewHolder(ItemRecyclerViewBinding.inflate(inFlater, parent, false))
    }

    override fun onBindViewHolder(holder: FirstRecyclerViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int = items.size
    fun updateData(items: List<RvModel>?) {
    this.items.clear()
        items?.let{
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }


    inner class FirstRecyclerViewHolder(private val binding: ItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RvModel) {
            binding.titleTextVew.text = item.title
            binding.descriptionTextView.text=item.description
        }
    }
}