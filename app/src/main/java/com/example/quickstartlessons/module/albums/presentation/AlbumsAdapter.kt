package com.example.quickstartlessons.module.albums.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemAlbumsBinding
import com.example.quickstartlessons.module.albums.data.model.response.AlbumDto

class AlbumsAdapter : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items = mutableListOf<AlbumDto>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(ItemAlbumsBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateAdapter(item: List<AlbumDto>) {
        items.clear()
        item?.let {
            items.addAll(it)
        }
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(album: AlbumDto)

    }

    inner class AlbumViewHolder(private val binding: ItemAlbumsBinding) : BaseViewHolder(binding.root) {
        override fun bind(album: AlbumDto) {
            binding.photoText.text = album.title
        }
    }
}