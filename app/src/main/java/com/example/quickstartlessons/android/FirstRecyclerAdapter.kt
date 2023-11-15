package com.example.quickstartlessons.android

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding

class FirstRecyclerAdapter(private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<FirstRecyclerAdapter.FirstRecyclerViewHolder>() {

    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items: MutableList<Model> = mutableListOf()

    override fun onAttachedToRecyclerView(arsenalFCSpecials: RecyclerView) {
        super.onAttachedToRecyclerView(arsenalFCSpecials)
        context = arsenalFCSpecials.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstRecyclerViewHolder {
        return FirstRecyclerViewHolder(ItemRecycleViewBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: FirstRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<Model>?) {
        this.items.clear()
        items?.let {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    inner class FirstRecyclerViewHolder(private val binding: ItemRecycleViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val countryAdapter: CountryAdapter = CountryAdapter()

        init {
            binding.expendedImage.adapter = countryAdapter
            binding.rootLayout.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    items[adapterPosition].isExpanded = !items[adapterPosition].isExpanded
                    onItemClick.invoke(adapterPosition)
                    notifyItemChanged(adapterPosition)
                }
            }
        }

        fun bind(model: Model) {
            binding.title.text = model.title
            binding.titleNumber.text = model.number
            Glide.with(binding.imageViewFlag).load(model.image).into(binding.imageViewFlag)
            val rotation = if (model.isExpanded) 180f else 0f
            binding.navigateNext.rotation = rotation
            countryAdapter.updateData(model.itemList1)
            binding.expendedImage.isVisible = model.isExpanded

        }
    }
}


