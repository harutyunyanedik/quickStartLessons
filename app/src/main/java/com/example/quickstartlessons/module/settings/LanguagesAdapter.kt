package com.example.quickstartlessons.module.settings

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.LanguageItemBinding
import com.example.quickstartlessons.module.base.model.LocaleEnum
import com.example.quickstartlessons.module.base.model.SelectableData

class LanguagesAdapter(val onLanguageClick: (LocaleEnum) -> Unit): RecyclerView.Adapter<LanguagesAdapter.LanguageViewHolder>() {

    private val items = mutableListOf<SelectableData<LocaleEnum>>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(LanguageItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<SelectableData<LocaleEnum>>?) {
        items.clear()
        list?.let {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }


    @SuppressLint("NotifyDataSetChanged")
    inner class LanguageViewHolder(private val binding: LanguageItemBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    cleanSelections()
                    onLanguageClick.invoke(items[adapterPosition].data)
                    items[adapterPosition].isSelected = true
                    notifyDataSetChanged()
                }
            }
        }

        private fun cleanSelections() {
            items.onEach {
                it.isSelected = false
            }
        }
        fun bind(item: SelectableData<LocaleEnum>) {
            binding.textViewLanguage.text = context.getString(item.data.languageResId)
            val selectedColor = if (item.isSelected) R.color.blue_light else R.color.white
            binding.constraintLayoutLanguage.background = ContextCompat.getDrawable(context, selectedColor)
        }
    }
}