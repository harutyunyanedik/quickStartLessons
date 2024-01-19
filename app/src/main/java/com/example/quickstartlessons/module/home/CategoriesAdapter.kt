package com.example.quickstartlessons.module.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.CategoryItemBinding
import com.example.quickstartlessons.module.base.utils.QsConstants
import com.example.quickstartlessons.module.category.data.model.Category
import java.util.Locale

class CategoriesAdapter(private val onCategoryClick: (String) -> Unit) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private val items = mutableListOf<Category>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var selectedIndex = QsConstants.ZERO

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<Category>?) {
        items.clear()
        items.add(Category("All products", R.color.blue_light))
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class CategoryViewHolder(private val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onCategoryClick.invoke(items[adapterPosition].category)
                    selectedIndex = adapterPosition
                    notifyDataSetChanged()
                }
            }
        }

        fun bind(item: Category) {
            binding.textViewCategory.text = item.category.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            if (selectedIndex == adapterPosition){
                item.isSelected = R.color.blue_light
            } else {
                item.isSelected = R.color.white
            }
            binding.constraintLayoutCategories.background = ContextCompat.getDrawable(context, item.isSelected)
        }
    }
}