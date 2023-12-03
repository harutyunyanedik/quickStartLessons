package com.example.quickstartlessons.android.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.android.models.Model
import com.example.quickstartlessons.databinding.SecondRecycleViewBinding


class TopNewsAdapter(private val onItemClickOne: (String) -> Unit) : RecyclerView.Adapter<TopNewsAdapter.TopNewsViewHolder>() {
    lateinit var inflater: LayoutInflater
    lateinit var context: Context
    private val item: MutableList<Model> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        return TopNewsViewHolder(SecondRecycleViewBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size


    fun updateData(event: List<Model>?) {
        this.item.clear()
        event?.let {
            item.addAll(event)
        }
    }

    inner class TopNewsViewHolder(private val binding: SecondRecycleViewBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.title.setOnClickListener {
                onItemClickOne.invoke(item[adapterPosition].title)
            }
            binding.searchButton.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    item[adapterPosition].isSearch != item[adapterPosition].isSearch
                    onItemClickOne.invoke(item[adapterPosition].isSearch.toString())
                    notifyItemChanged(adapterPosition)
                }
            }
        }

        fun bind(item: Model) {
            binding.title.text = item.title
            Glide.with(context).load(item.image).into(binding.blankImage)
            binding.searchButton.isClickable = item.isSearch
        }
    }
}
