package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.DescriptionItemBinding
import com.example.quickstartlessons.databinding.HeaderItemBinding
import com.example.quickstartlessons.databinding.TitleItemBinding
import com.example.quickstartlessons.models.RecyclerViewModel

class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.BaseViewHolder>() {

    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    private val items = mutableListOf<RecyclerViewModel>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            HEADER -> HeaderViewHolder(HeaderItemBinding.inflate(inflater, parent, false))
            TITLE -> TitleViewHolder(TitleItemBinding.inflate(inflater, parent, false))
            DESCRIPTION -> DescriptionViewHolder(DescriptionItemBinding.inflate(inflater, parent, false))
            else -> HeaderViewHolder(HeaderItemBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return if (items[position].city == null && items[position].title == null) {
            2
        } else if (items[position].city == null && items[position].description == null) {
            1
        } else {
            0
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(list: List<RecyclerViewModel>?) {
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view.rootView) {
        abstract fun bind(item: RecyclerViewModel)
    }

    inner class HeaderViewHolder(private val binding: HeaderItemBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RecyclerViewModel) {
            binding.textViewHeader.text = item.city
        }
    }

    inner class TitleViewHolder(private val binding: TitleItemBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RecyclerViewModel) {
            binding.textViewTitle.text = item.title
        }
    }

    inner class DescriptionViewHolder(private val binding: DescriptionItemBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RecyclerViewModel) {
            binding.textViewDescription.text = item.description
        }
    }

    companion object {
        const val HEADER = 0
        const val TITLE = 1
        const val DESCRIPTION = 2
    }
}