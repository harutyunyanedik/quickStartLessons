package com.example.quickstartlessons.module.albums.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentPhotosBinding
import com.example.quickstartlessons.module.albums.data.model.response.PhotoDto

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items = mutableListOf<PhotoDto>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(FragmentPhotosBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateAdapter(item: List<PhotoDto>) {
        items.clear()
        item.let {
            items.addAll(it)
        }
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(album: PhotoDto)

    }

    inner class PhotosViewHolder(private val binding: FragmentPhotosBinding) : BaseViewHolder(binding.root) {
        override fun bind(photo: PhotoDto) {
            binding.photoTitle.text = photo.title
        }
    }
}