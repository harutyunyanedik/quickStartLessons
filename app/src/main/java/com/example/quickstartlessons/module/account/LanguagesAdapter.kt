package com.example.quickstartlessons.module.account

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.LanguageItemBinding
import com.example.quickstartlessons.module.base.model.LocaleEnum

class LanguagesAdapter(val onLanguageClick: (LocaleEnum) -> Unit) : RecyclerView.Adapter<LanguagesAdapter.LanguageViewHolder>() {

    private val items = mutableListOf<SelectableProvider<LocaleEnum>>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(recyclerView.context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(LanguageItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(list: List<SelectableProvider<LocaleEnum>>?) {
        items.clear()
        list?.let {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }


    @SuppressLint("NotifyDataSetChanged")
    inner class LanguageViewHolder(private val binding: LanguageItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onLanguageClick.invoke(items[adapterPosition].data)
                    clearSelections()
                    items[adapterPosition].selected = true
                    notifyDataSetChanged()
                }
            }
        }

        private fun clearSelections() {
            items.onEach { it.selected = false }
        }

        fun bind(item: SelectableProvider<LocaleEnum>) {
            binding.textViewLanguage.text = context.getString(item.data.languageResId)
            val color = if (item.selected) R.color.blue_light else R.color.white
            binding.root.background = ContextCompat.getDrawable(context, color)
        }
    }
}

class SelectableProvider<T>(var data: T, var selected: Boolean = false)