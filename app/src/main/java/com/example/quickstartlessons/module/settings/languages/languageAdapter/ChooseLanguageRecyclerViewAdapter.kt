package com.example.quickstartlessons.module.settings.languages.languageAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.RvChooseLanguageBinding
import com.example.quickstartlessons.module.base.model.LocaleEnum
import com.example.quickstartlessons.module.base.model.SelectableData


class ChooseLanguageRecyclerViewAdapter(private var onItemClick: (LocaleEnum) -> Unit) : RecyclerView.Adapter<ChooseLanguageRecyclerViewAdapter.BaseViewHolder>() {

    private val items: MutableList<SelectableData<LocaleEnum>> = mutableListOf()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ChooseLanguageRecyclerViewHolder(RvChooseLanguageBinding.inflate(inflater, parent, false))
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
    fun updateData(item: List<SelectableData<LocaleEnum>>?) {
        this.items.clear()
        item?.let {
            this.items.addAll(item)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: SelectableData<LocaleEnum>)
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class ChooseLanguageRecyclerViewHolder(private val binding: RvChooseLanguageBinding) : BaseViewHolder(binding.root) {
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
            binding.languages.text = context.getString(item.data.languageResId)
            val selectedColor = if (item.isSelected) R.color.teal_200 else R.color.white
            binding.languages.background = ContextCompat.getDrawable(context, selectedColor)
        }
    }
}