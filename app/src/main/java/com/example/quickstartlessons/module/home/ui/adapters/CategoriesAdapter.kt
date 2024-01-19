package com.example.quickstartlessons.module.home.ui.adapters // todo ui/adapter/

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentCategoriesBinding


class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.BaseViewHolder>() {
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private val items: MutableList<String> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return CategoriesViewHolder(FragmentCategoriesBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount()= items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataCategories(list:List<String>) {
        items.clear()
        list.let {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }

   abstract class BaseViewHolder(view: View):RecyclerView.ViewHolder(view){
      abstract fun bind(item:String)

   }

    inner class CategoriesViewHolder(private val binding: FragmentCategoriesBinding): BaseViewHolder(binding.root){
        override fun bind(item: String) {
            binding.categoriesName.text = item
        }

    }
}
