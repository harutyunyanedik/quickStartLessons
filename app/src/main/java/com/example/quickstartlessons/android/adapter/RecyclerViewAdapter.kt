package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.model.RvFirstModel
import com.example.quickstartlessons.databinding.ActivityTwoBinding
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding


class RecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerViewAdapter.BaseViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items = mutableListOf<RvFirstModel>()
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            COUNTRY -> FirstRecyclerViewHolder(
                ItemRecycleViewBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            HEADER -> SecondRecyclerViewHolder(ActivityTwoBinding.inflate(inflater, parent, false))

            else -> FirstRecyclerViewHolder(ItemRecycleViewBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].header == null && items[position].standard == null) {
            COUNTRY
        } else {
            HEADER
        }
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<RvFirstModel>?) {
        items.clear()
        item?.let {
            items.addAll(item)
            notifyDataSetChanged()
        }
    }

    abstract class BaseViewHolder(itemType: View) : RecyclerView.ViewHolder(itemType) {
        abstract fun bind(item: RvFirstModel)
    }

    inner class FirstRecyclerViewHolder(private val binding: ItemRecycleViewBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RvFirstModel) {
            binding.country.text = item.country
        }
    }

    inner class SecondRecyclerViewHolder(private val binding: ActivityTwoBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RvFirstModel) {
            binding.droidcon.text = item.header
            binding.droidconInCountry.text = item.standard
        }
    }


    companion object {
        const val COUNTRY: Int = 0
        const val HEADER: Int = 1
    }
}