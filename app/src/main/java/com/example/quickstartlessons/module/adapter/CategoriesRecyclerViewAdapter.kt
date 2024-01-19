package com.example.quickstartlessons.module.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.RvHomeCategoriseBinding

class CategoriesRecyclerViewAdapter(private var onItem: (String) -> Unit) : RecyclerView.Adapter<CategoriesRecyclerViewAdapter.BaseViewHolder>() {

    private val item: MutableList<String> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return CategoriesRecyclerViewHolder(RvHomeCategoriseBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<String>?) {
        this.item.clear()
        item?.let {
            this.item.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: String)
    }

    inner class CategoriesRecyclerViewHolder(private val binding: RvHomeCategoriseBinding) : BaseViewHolder(binding.root) {
        init {
            binding.categories.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItem.invoke(binding.categoriesText.text.toString())
                }
            }
        }

        override fun bind(item: String) {
            binding.categoriesText.text = item
        }
    }

}
