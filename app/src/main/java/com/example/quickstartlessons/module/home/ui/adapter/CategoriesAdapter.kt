package com.example.quickstartlessons.module.home.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ItemCategoriesDataBinding
import com.example.quickstartlessons.module.base.utils.QsConstants
import com.example.quickstartlessons.module.product.data.model.response.ProductDto
import java.util.Locale


class CategoriesAdapter(private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items: MutableList<String> = mutableListOf()
    private var select = -1

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(ItemCategoriesDataBinding.inflate(inflater, parent, false))
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

    @SuppressLint("ResourceAsColor", "NotifyDataSetChanged")
    inner class CategoriesViewHolder(private val binding: ItemCategoriesDataBinding) : RecyclerView.ViewHolder(binding.root) {

        init {

            binding.constraintByCategory.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick.invoke(items[adapterPosition])
                    items[adapterPosition]!=items[adapterPosition]
                    select = adapterPosition

                    notifyDataSetChanged()
                }

            }
        }

        @SuppressLint("ResourceAsColor")
        fun bind(item: String) {
            binding.categories.text = item.replaceFirstChar { it.uppercase()
            }
          if(select==adapterPosition){
              binding.constraintByCategory.setBackgroundColor(R.color.purple_200)
          }
          else{
              binding.constraintByCategory.setBackgroundColor(R.color.white)
          }
        }
    }
}