package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.quickstartlessons.databinding.ItemRecycleViewBinding

class AdapterImageRecyclerView : RecyclerView.Adapter<AdapterImageRecyclerView.ImageViewHolder>() {
    val items: MutableList<ImageModel> = mutableListOf()
    lateinit var context: Context
    lateinit var inflater: LayoutInflater


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemRecycleViewBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<ImageModel>?) {
        items.clear()
        item?.let {
            items.addAll(item)
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class ImageViewHolder(private val item: ItemRecycleViewBinding) :
        RecyclerView.ViewHolder(item.root) {
        val childAdapter=AdapterChildRecyclerView()
        init {
            item.recyclerViewChild.adapter=childAdapter
            item.imageItem.setOnClickListener{
                if(adapterPosition!=RecyclerView.NO_POSITION){
                    items[adapterPosition].isExpanded=!items[adapterPosition].isExpanded
                    notifyDataSetChanged()
                }
            }
        }
        fun bind(binding: ImageModel) {
             item.recyclerViewChild.isVisible=binding.isExpanded
            Glide.with(context).load(binding.imageModel).into(item.imageItem)
            childAdapter.updateData(binding.list)
        }
    }
}
data class ImageModel(val imageModel:String, var isExpanded:Boolean,val list: List<ChildModel>)