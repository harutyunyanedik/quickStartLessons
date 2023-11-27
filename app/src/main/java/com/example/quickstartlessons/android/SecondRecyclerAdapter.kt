package com.example.quickstartlessons.android

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.SecondRecycleViewBinding


class SecondRecyclerAdapter : RecyclerView.Adapter<SecondRecyclerAdapter.SecondRecyclerViewHolder>() {
    lateinit var inFlater: LayoutInflater
    lateinit var context: Context
    private val item: MutableList<Model> = mutableListOf<Model>()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inFlater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SecondRecyclerAdapter.SecondRecyclerViewHolder {
        return SecondRecyclerViewHolder(SecondRecycleViewBinding.inflate(inFlater, parent, false))
    }

    override fun onBindViewHolder(
        holder: SecondRecyclerAdapter.SecondRecyclerViewHolder,
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

    inner class SecondRecyclerViewHolder(private val binding: SecondRecycleViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Model) {
            binding.title.text = item.title
        Glide.with(context).load(item.image).into(binding.blankImage)
        }

    }
}