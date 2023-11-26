package com.example.quickstartlessons.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ParentItemBinding
import com.example.quickstartlessons.models.GeneralModel

class GeneralAdapter : RecyclerView.Adapter<GeneralAdapter.GeneralViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var items = mutableListOf<GeneralModel>()
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {
        return GeneralViewHolder(ParentItemBinding.inflate(inflater))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class GeneralViewHolder(private val binding: ParentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GeneralModel) {
            binding.news.text = item.title

        }

    }
}