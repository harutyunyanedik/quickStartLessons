package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemReciclerViewBinding
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto

class ImagesRecyclerViewAdapter(private val onItemClick: (Boolean) -> Unit) : RecyclerView.Adapter<ImagesRecyclerViewAdapter.BaseViewHolder>() {

    private val item: MutableList<AlbumDto> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ImagesRecyclerViewHolder(ItemReciclerViewBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<AlbumDto>?) {
        this.item.clear()
        item?.let {
            this.item.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: AlbumDto)
    }

    inner class ImagesRecyclerViewHolder(private val binding: ItemReciclerViewBinding) : BaseViewHolder(binding.root) {

        init {
            binding.rvFragments.setOnClickListener {
                onItemClick.invoke(true)
            }
        }

        override fun bind(item: AlbumDto) {
            binding.userId.text = item.id.toString()
            binding.title.text = item.title
            Glide.with(context).load(item.imageUrl).into(binding.imageUrl)
        }
    }
}
