package com.example.quickstartlessons.module.albums.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.AlbumItemBinding
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto

class AlbumsAdapter(private val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<AlbumsAdapter.BaseViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items = mutableListOf<AlbumDto>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return AlbumsViewHolder(AlbumItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newItems: List<AlbumDto>?){
        items.clear()
        newItems?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view){
        abstract fun bind(album: AlbumDto)
    }

    inner class AlbumsViewHolder(private val binding : AlbumItemBinding) : BaseViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION){
                    onItemClick.invoke(items[adapterPosition].id)
                }
            }
        }
        override
        fun bind(album: AlbumDto){
            binding.textViewTitle.text = album.title
            Glide.with(context).load(album.thumbnailUrl).into(binding.imageViewThumbnail)
        }
    }
}