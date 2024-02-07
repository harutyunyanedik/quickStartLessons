package com.example.quickstartlessons.module.posts

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.PostItemBinding
import com.example.quickstartlessons.module.postsmodel.data.net.responce.PostDto

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    private val items = mutableListOf<PostDto>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<PostDto>?) {
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class PostViewHolder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostDto) {
            binding.titleTV.text = item.title
            binding.bodyTV.text = item.body
        }
    }
}