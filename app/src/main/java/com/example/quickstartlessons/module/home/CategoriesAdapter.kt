package com.example.quickstartlessons.module.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentCategoriesBinding

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items: MutableList<String> = mutableListOf()
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(FragmentCategoriesBinding.inflate(inflater, parent, false))
    }
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataCategories(list: List<String>?) { // todo list rename to items
        items.clear()
        list?.let {
            items.addAll(items) // todo addAll(list)
        }
        notifyDataSetChanged()
    }

//    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        abstract fun bind(item: String)
//
//    } // todo inchi es comment arel? het ber baseViewHolder ov sarqi

    inner class CategoriesViewHolder(private val binding: FragmentCategoriesBinding) :RecyclerView.ViewHolder(binding.root) {
         fun bind(item: String) {
            binding.categoriesName.text = item

        }
    }
}