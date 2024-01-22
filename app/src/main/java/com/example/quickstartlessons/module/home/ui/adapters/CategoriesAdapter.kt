package com.example.quickstartlessons.module.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentCategoriesBinding
import com.example.quickstartlessons.module.base.utils.QsConstants

class CategoriesAdapter(private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<CategoriesAdapter.BaseViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items: MutableList<String> = mutableListOf()
    private var select = QsConstants.NO_VALUE
    private var isSelected = R.color.white

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return CategoriesViewHolder(FragmentCategoriesBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataCategories(list: List<String>) {
        this.items.clear()
        list.let {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: String)
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class CategoriesViewHolder(private val binding: FragmentCategoriesBinding) : BaseViewHolder(binding.root) {
        init {
            binding.constraintLayout.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick.invoke(items[adapterPosition])
                    select = adapterPosition
                    notifyDataSetChanged()
                }
            }
        }

        @SuppressLint("ResourceAsColor")
        override fun bind(item: String) {
            binding.categoriesName.text = item.replaceFirstChar {
                it.uppercase()
            }
            isSelected = if (select == adapterPosition) {
                R.color.teal_700
            } else {
                R.color.white
            }
            binding.constraintLayout.background = ContextCompat.getDrawable(context, isSelected)
        }


    }
}