package com.example.quickstartlessons.module.settings

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ItemLanguagesBinding
import com.example.quickstartlessons.module.base.model.LocaleEnum
import com.example.quickstartlessons.module.base.model.SelectableData

class LanguageAdapter(private val onItemClick: (LocaleEnum) -> Unit) : RecyclerView.Adapter<LanguageAdapter.BaseViewHolder>() {
    private var items = mutableListOf<SelectableData<LocaleEnum>>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return LanguageViewHolder(ItemLanguagesBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataLanguages(list: List<SelectableData<LocaleEnum>>) {
        this.items.clear()
        list.let {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: SelectableData<LocaleEnum>)
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class LanguageViewHolder(private val binding: ItemLanguagesBinding) : BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    clearSelections()
                    onItemClick.invoke(items[adapterPosition].data)
                    items[adapterPosition].isSelected = true
                    notifyDataSetChanged()
                }
            }
        }

        private fun clearSelections() {
            items.onEach {
                it.isSelected = false
            }
        }

        override fun bind(item: SelectableData<LocaleEnum>) {
            binding.language.text = context.getString(item.data.languageResId)
            val selectedColor = if (item.isSelected) R.color.teal_700 else R.color.white
            binding.constraintLanguage.background = ContextCompat.getDrawable(context, selectedColor)
        }
    }
}
