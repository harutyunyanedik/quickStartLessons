package com.example.quickstartlessons.homework

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.FragmentPhotoBinding

class AdapterPhoto(private val onClick: (String) -> Unit) : RecyclerView.Adapter<AdapterPhoto.PhotoViewHolder>() {
    val items = mutableListOf<Photo>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(FragmentPhotoBinding.inflate(inflater, parent, false))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<Photo>?) {
        items.clear()
        item?.let {
            items.addAll(item)
            notifyDataSetChanged()
        }

    }


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class PhotoViewHolder(private val binding: FragmentPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.photoIn150.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    items[adapterPosition].url?.let { it1 -> onClick.invoke(it1) }
                    notifyItemChanged(adapterPosition)
                }
            }
        }

        fun bind(item: Photo) {
            Glide.with(context).load(item.url).into(binding.photoIn600)
            Glide.with(context).load(item.thumbnailUrl).into(binding.photoIn150)
            binding.PhotoTitle.text = item.title
            binding.idImageView.text= item.id.toString()
        }
    }
}