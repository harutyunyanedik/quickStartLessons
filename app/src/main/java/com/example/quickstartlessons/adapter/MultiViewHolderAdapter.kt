package com.example.quickstartlessons.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.DescriptionItemBinding
import com.example.quickstartlessons.databinding.ItemRvHeaderBinding
import com.example.quickstartlessons.databinding.ItemRvStandardBinding
import com.example.quickstartlessons.model.RecyclerViewModel

class MultiViewHolderAdapter : RecyclerView.Adapter<MultiViewHolderAdapter.BaseViewHolder>() {
    private val items: MutableList<RecyclerViewModel> = mutableListOf()
    private lateinit var inflate: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        inflate = LayoutInflater.from(recyclerView.context)
    }

    fun updateData(items: List<RecyclerViewModel>?) {
        this.items.clear()
        items?.let { this.items.addAll(items) }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: RecyclerViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            HEADER -> ViewHolderStandard(ItemRvStandardBinding.inflate(inflate, parent, false))
            STANDART -> HeaderViewHolder(ItemRvHeaderBinding.inflate(inflate, parent, false))
            else -> DescriptionViewHolder(DescriptionItemBinding.inflate(inflate, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].header == null) {
            DESCRIPTION
        } else if (items[position].header == null && items[position].description == null) {
            STANDART
        } else {
            HEADER
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }


    override fun getItemCount(): Int = items.size


    inner class ViewHolderStandard(private val binding: ItemRvStandardBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RecyclerViewModel) {
            binding.titleTextView.text = item.title
        }

    }

    inner class HeaderViewHolder(private val binding: ItemRvHeaderBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RecyclerViewModel) {
            binding.headerTextView.text = item.header
        }
    }

    inner class DescriptionViewHolder(private val binding: DescriptionItemBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RecyclerViewModel) {
            binding.descriptionTextView.text = item.description
        }

    }

    companion object {
        const val HEADER: Int = 0
        const val STANDART: Int = 1
        const val DESCRIPTION = 2
    }
}