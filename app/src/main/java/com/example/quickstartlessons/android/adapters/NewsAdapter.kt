package com.example.quickstartlessons.android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.android.models.NewsModel
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    lateinit var inFlater: LayoutInflater
    lateinit var contex: Context
    private val item: MutableList<NewsModel> = mutableListOf<NewsModel>()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        contex = recyclerView.context
        inFlater = LayoutInflater.from(contex)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
        return NewsViewHolder(ItemRecycleViewBinding.inflate(inFlater, parent, false))
    }

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size


    fun updateData(event: List<NewsModel>?) {
        this.item.clear()
        event?.let {
            item.addAll(event)
        }
    }

    inner class NewsViewHolder(private val binding: ItemRecycleViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsModel) {
            binding.iconText.text=item.text
            Glide.with(contex).load(item.image).into(binding.image)

        }
    }


}
