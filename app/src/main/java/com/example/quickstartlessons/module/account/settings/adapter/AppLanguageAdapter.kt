package com.example.quickstartlessons.module.account.settings.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ItemChangeLangugaeBinding
import com.example.quickstartlessons.module.base.utils.QsConstants

class AppLanguageAdapter(private val onItemClick:()->Unit) : RecyclerView.Adapter<AppLanguageAdapter.ChangeLanguageViewHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items = mutableListOf<String>()
    private var isSelected=QsConstants.NO_VALUE

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChangeLanguageViewHolder {
        return ChangeLanguageViewHolder(ItemChangeLangugaeBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ChangeLanguageViewHolder, position: Int) {
        holder.bind(items[position])
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item:List<String>?){
        items.clear()
        item?.let {
            items.addAll(item)
        }
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    inner class ChangeLanguageViewHolder(private val binding: ItemChangeLangugaeBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.language.setOnClickListener {
                if(adapterPosition!=RecyclerView.NO_POSITION){
                    onItemClick.invoke()

                    isSelected=adapterPosition
                    notifyDataSetChanged()

                }
            }
        }
        fun bind(item: String) {
            binding.language.text = item
            val color=if(isSelected==adapterPosition){
                R.color.purple_500

            }else{
                R.color.color_black_10
            }
           binding.constraintLanguage.background= ContextCompat.getDrawable(context, color)
        }
    }
}