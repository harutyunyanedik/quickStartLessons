package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.model.RvFirstModel
import com.example.quickstartlessons.databinding.ActivityThreeBinding
import com.example.quickstartlessons.databinding.ActivityTwoBinding
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding
import java.time.chrono.HijrahEra

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
            STANDARD -> ThirdRecyclerViewHolder(
                ActivityThreeBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            else -> FirstRecyclerViewHolder(ItemRecycleViewBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            items[position].textCardView==null &&items[position].textOne==null && items[position].textTwo==null-> STANDARD
            items[position].textCardView==null && items[position].oneTimeStandard==null && items[position].oneTimeHeader==null-> HEADER
            else-> COUNTRY
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
            binding.country.text = item.textCardView
        }
    }

    inner class SecondRecyclerViewHolder(private val binding: ActivityTwoBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RvFirstModel) {
            binding.textOne.text = item.textOne
            binding.textTwo.text = item.textTwo
        }
    }

    inner class ThirdRecyclerViewHolder(private val binding: ActivityThreeBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(item: RvFirstModel) {
            binding.OneTimeHeader.text = item.oneTimeHeader
            binding.oneTimeStandard.text = item.oneTimeStandard
        }

    }

    companion object {
        const val COUNTRY: Int = 0
        const val HEADER: Int = 1
        const val STANDARD: Int = 2

    }
}