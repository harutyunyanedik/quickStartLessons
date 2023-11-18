package com.example.quickstartlessons.android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.models.ModelStandard
import com.example.quickstartlessons.databinding.ItemRvHeaderBinding
import com.example.quickstartlessons.databinding.ItemRvStandardBinding

class MultiViewHolderAdapter : RecyclerView.Adapter<MultiViewHolderAdapter.BaseViewHolder>() {
    private val items: MutableList<ModelStandard> = mutableListOf()
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        inflater = LayoutInflater.from(recyclerView.context)
    }

    fun updateData(items: List<ModelStandard>?) {
        this.items.clear()
        items?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: ModelStandard)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            STANDARD -> StandardViewHolder(ItemRvStandardBinding.inflate(inflater, parent, false))
            HEADER -> HeaderViewHolder(ItemRvHeaderBinding.inflate(inflater, parent, false))
            else -> StandardViewHolder(ItemRvStandardBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].header != null) {
            return HEADER
        } else STANDARD

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }


    override fun getItemCount(): Int = items.size


    inner class StandardViewHolder(private val binding: ItemRvStandardBinding) :
        BaseViewHolder(binding.root) {

        override fun bind(item: ModelStandard) {
            binding.standardText.text = item.title
        }

    }

    inner class HeaderViewHolder(private val binding: ItemRvHeaderBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: ModelStandard) {
            binding.headerText.text = item.header

        }
    }

    companion object {
        const val STANDARD: Int = 0
        const val HEADER: Int = 1
    }
}