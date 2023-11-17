package com.example.quickstartlessons.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.ItemRecyclerBinding
import com.example.quickstartlessons.model.AppModel

class AppRecycleAdapter( val onClickImage:((AppModel)->Unit)?=null) : RecyclerView.Adapter<AppRecycleAdapter.AppRecycleAdapterViewHolder>() {
    private lateinit var inflate: LayoutInflater
    private lateinit var context: Context
    private val items: MutableList<AppModel> = mutableListOf()
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflate = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppRecycleAdapterViewHolder {
        return AppRecycleAdapterViewHolder(ItemRecyclerBinding.inflate(inflate, parent, false))
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<AppModel>?) {
        this.items.clear()
        items?.let { this.items.addAll(items) }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AppRecycleAdapterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class AppRecycleAdapterViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init{
            binding.imageView.setOnClickListener{
                if(adapterPosition !=RecyclerView.NO_POSITION){
                    onClickImage?.invoke(items[adapterPosition])
                }
            }
        }
        fun bind(item: AppModel) {
            Glide.with(context).load(item.imageUrl).into(binding.imageView)
        }
    }
}