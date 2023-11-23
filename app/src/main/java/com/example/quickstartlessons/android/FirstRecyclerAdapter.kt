package com.example.quickstartlessons.android

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding

class FirstRecyclerAdapter : RecyclerView.Adapter<FirstRecyclerAdapter.FirstRecyclerViewHolder>() {
    lateinit var inFlater: LayoutInflater
    lateinit var contex: Context
    private val item: MutableList<Model> = mutableListOf<Model>()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        contex = recyclerView.context
        inFlater = LayoutInflater.from(contex)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstRecyclerAdapter.FirstRecyclerViewHolder {
        return FirstRecyclerViewHolder(ItemRecycleViewBinding.inflate(inFlater, parent, false))
    }

    override fun onBindViewHolder(
        holder: FirstRecyclerAdapter.FirstRecyclerViewHolder,
        position: Int
    ) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size


    fun updateData(event: List<Model>?) {
        this.item.clear()
        event?.let {
            item.addAll(event)
        }

    }

    inner class FirstRecyclerViewHolder(private val binding: ItemRecycleViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Model) {
            binding.title.text = item.title

        }

    }
}