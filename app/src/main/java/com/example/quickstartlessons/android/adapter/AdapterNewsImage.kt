package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.FragmentFirsPageNewsBinding
import com.example.quickstartlessons.android.model.RvNewsModel

class AdapterNewsImage(val onClick: (String,String) -> Unit):RecyclerView.Adapter<AdapterNewsImage.NewsImageHolder>(){
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    val items = mutableListOf<RvNewsModel>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<RvNewsModel>?) {
        items.clear()
        item?.let {
            items.addAll(item)
        }
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsImageHolder {
      return NewsImageHolder(FragmentFirsPageNewsBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount(): Int=items.size

    override fun onBindViewHolder(holder: NewsImageHolder, position: Int) {
          holder.bind(items[position])
    }
    inner class NewsImageHolder(private val binding:FragmentFirsPageNewsBinding):RecyclerView.ViewHolder(binding.root){
        init{
            binding.newsImage.setOnClickListener {
                if(adapterPosition!=RecyclerView.NO_POSITION){
                    onClick.invoke(items[adapterPosition].newsImage,items[adapterPosition].description)
                    notifyItemChanged(adapterPosition)

                }
            }
        }
      fun bind(item: RvNewsModel){
          binding.newsText.text=item.description
          Glide.with(context).load(item.newsImage).into(binding.newsImage)
      }
    }
}