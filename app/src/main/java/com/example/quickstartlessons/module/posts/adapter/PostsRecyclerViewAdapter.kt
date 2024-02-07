package com.example.quickstartlessons.module.posts.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.RvPostsFragmentBinding
import com.example.quickstartlessons.module.base.utils.Prefs.getString
import com.example.quickstartlessons.module.posts.data.response.PostDto

class PostsRecyclerViewAdapter : RecyclerView.Adapter<PostsRecyclerViewAdapter.BaseViewHolder>() {

    private val items: MutableList<PostDto> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return PostsRecyclerViewHolder(RvPostsFragmentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<PostDto>?) {
        this.items.clear()
        item?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: PostDto)
    }

    inner class PostsRecyclerViewHolder(private val binding: RvPostsFragmentBinding) : BaseViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        override fun bind(item: PostDto) {
            binding.postsBody.text =" $item.body"
            binding.postsTitle.text =   "  ${item.title}"
        }
    }

}