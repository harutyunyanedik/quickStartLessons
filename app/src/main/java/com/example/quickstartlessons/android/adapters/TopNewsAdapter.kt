package com.example.quickstartlessons.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.android.models.TopModel
import com.example.quickstartlessons.databinding.TopNewsAdapterBinding

class TopNewsAdapter(private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<TopNewsAdapter.TopNewsViewHolder>() {
    lateinit var inflater: LayoutInflater
    lateinit var context: Context
    private val item: MutableList<TopModel> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        return TopNewsViewHolder(TopNewsAdapterBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size


    fun updateData(event: List<TopModel>?) {
        this.item.clear()
        event?.let {
            item.addAll(event)
        }
    }

    inner class TopNewsViewHolder(private val binding: TopNewsAdapterBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.recyclerViewTwo.setOnClickListener {
                onItemClick.invoke(item[adapterPosition].text)
            }
        }

        fun bind(item:TopModel) {
            binding.title.text = item.text
            Glide.with(context).load(item.image).into(binding.blankImage)
        }
    }
}