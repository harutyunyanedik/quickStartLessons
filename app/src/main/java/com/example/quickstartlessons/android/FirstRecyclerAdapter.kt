package com.example.quickstartlessons.android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.FirsyRecyclerViewBinding
import com.example.quickstartlessons.databinding.SecondRecycleViewBinding


class FirstRecyclerAdapter : RecyclerView.Adapter<FirstRecyclerAdapter.FirstRecyclerViewHolder>() {
    lateinit var inFlater: LayoutInflater
    lateinit var context: Context
    private val item: MutableList<ModelOne> = mutableListOf<ModelOne>()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inFlater = LayoutInflater.from(context)
    }


    override fun onBindViewHolder(
        holder: FirstRecyclerAdapter.FirstRecyclerViewHolder, position: Int
    ) {
        holder.bind(item[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstRecyclerViewHolder {
        return FirstRecyclerViewHolder(FirsyRecyclerViewBinding.inflate(inFlater, parent, false))
    }

    override fun getItemCount(): Int = item.size

    fun updateData(event: List<ModelOne>?) {
        this.item.clear()
        event?.let {
            item.addAll(event)
        }

    }

    inner class FirstRecyclerViewHolder(private val binding: FirsyRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ModelOne) {
            binding.iconText.text = item.text
            Glide.with(context).load(item.image).into(binding.icon)
        }

    }


}
