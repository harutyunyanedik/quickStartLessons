package com.example.quickstartlessons.module.posts

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemPostBinding
import com.example.quickstartlessons.module.posts.data.PostDto

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.BaseViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var items = mutableListOf<PostDto>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return PostsViewHolder(ItemPostBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: PostDto) {
        items.clear()
        list.let {
            items.addAll(listOf(it))
        }
        notifyDataSetChanged()

    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: PostDto)
    }

    inner class PostsViewHolder(private val binding: ItemPostBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: PostDto) {
            binding.postsId.text = item.body
            binding.postsDescription.text = item.description
        }
    }
}