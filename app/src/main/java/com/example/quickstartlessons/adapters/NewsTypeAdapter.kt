package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ItemNewsTypeBinding
import com.example.quickstartlessons.models.Colors
import com.example.quickstartlessons.models.NewsType
import com.example.quickstartlessons.models.NewsTypeModel

class NewsTypeAdapter: RecyclerView.Adapter<NewsTypeAdapter.NewsTypeViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    private val items = mutableListOf<NewsTypeModel>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsTypeViewHolder {
        return NewsTypeViewHolder(ItemNewsTypeBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: NewsTypeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(items: List<NewsTypeModel>?){
        this.items.clear()
        items?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class NewsTypeViewHolder(private val binding: ItemNewsTypeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: NewsTypeModel){
            with(binding){
                textViewNewsType.text = item.title
                imageViewNewsType.background = when(item.picture){
                    NewsType.NEWS -> ContextCompat.getDrawable(context, R.drawable.ic_news)
                    NewsType.CRYPTO -> ContextCompat.getDrawable(context, R.drawable.ic_crypto)
                    NewsType.SPORT -> ContextCompat.getDrawable(context, R.drawable.ic_sport)
                    NewsType.STYLE-> ContextCompat.getDrawable(context, R.drawable.ic_style)
                    NewsType.MEDICINE -> ContextCompat.getDrawable(context, R.drawable.ic_medicine)
                    NewsType.TECH -> ContextCompat.getDrawable(context, R.drawable.ic_tech)
                }
                val color = when(item.color){
                    Colors.BLUE -> R.color.newsType_blue
                    Colors.ROSE -> R.color.newsType_rose
                    Colors.RED -> R.color.newsType_red
                    Colors.ORANGE -> R.color.newsType_orange
                    Colors.GREEN-> R.color.newsType_green
                    Colors.DARK_BLUE -> R.color.newsType_darkBlue
                }
                constraintLayoutNewsType.background = ContextCompat.getDrawable(context, color)
            }
        }
    }
}