package com.example.quickstartlessons.module.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentCategoriesBinding

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val item: MutableList<String> = mutableListOf()
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(FragmentCategoriesBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataCategories(items: List<String>?) { // todo list rename to items
        items.clear()
        items?.let {
            items.addAll(items)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: String)

        inner class CategoriesViewHolder(private val binding: FragmentCategoriesBinding) : BaseViewHolder(binding.root) {
            override fun bind(item: String) {
                binding.categoriesName.text = item

            }
        }
    }
}