package com.example.quickstartlessons.module.category.data.model.response.ui // todo home/ui/adapter/

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentCategoriesDataBinding


class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items: MutableList<String> = mutableListOf()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(FragmentCategoriesDataBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<String>?) {
        items.clear()
        item?.let {
            items.addAll(item)
        }
        notifyDataSetChanged()
    }

    inner class CategoriesViewHolder(private val binding: FragmentCategoriesDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.categories.text = item
        }
    }
}