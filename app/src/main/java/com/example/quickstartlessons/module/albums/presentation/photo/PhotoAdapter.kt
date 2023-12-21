package com.example.quickstartlessons.module.albums.presentation.photo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemPhotoBinding
import com.example.quickstartlessons.module.albums.data.model.response.PhotoDto

class PhotoAdapterAdapter(private val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<PhotoAdapterAdapter.BaseViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items = mutableListOf<PhotoDto>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return PhotoViewHolder(ItemPhotoBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newItems: List<PhotoDto>?){
        items.clear()
        newItems?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view){
        abstract fun bind(album: PhotoDto)
    }

    inner class PhotoViewHolder(private val binding : ItemPhotoBinding) : BaseViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION){
                    onItemClick.invoke(items[adapterPosition].id)
                }
            }
        }
        override
        fun bind(album: PhotoDto){
            binding.textTitle.text = album.title
            Glide.with(context).load(album.thumbnailUrl).into(binding.imageView)
        }
    }
}