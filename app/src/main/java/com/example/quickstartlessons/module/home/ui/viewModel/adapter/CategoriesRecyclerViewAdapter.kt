package com.example.quickstartlessons.module.home.ui.viewModel.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.RvHomeCategoriseBinding
import com.example.quickstartlessons.module.base.utils.QsConstants

class CategoriesRecyclerViewAdapter( private var onItemClick: (String,Int) -> Unit) : RecyclerView.Adapter<CategoriesRecyclerViewAdapter.BaseViewHolder>() {

    private val items: MutableList<String> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private var selectedIndex = QsConstants.NO_VALUE
    private var n = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return CategoriesRecyclerViewHolder(RvHomeCategoriseBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<String>?) {
        this.items.clear()
        item?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }
    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: String)
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class CategoriesRecyclerViewHolder(private val binding: RvHomeCategoriseBinding) : BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener{
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    n += 1
                    onItemClick.invoke(binding.categoriesText.text.toString(),n)
                    selectedIndex = adapterPosition
                    notifyDataSetChanged()
                }
            }
            }



        override fun bind(item: String) {
                binding.categoriesText.text = item.uppercase()
                if (selectedIndex == adapterPosition && n % 2 != 1) {
                    binding.categories.background = ContextCompat.getDrawable(context, R.drawable.component_clicked_color)
                } else {
                    binding.categories.background = ContextCompat.getDrawable(context, R.color.white)
                }
        }
    }

}


