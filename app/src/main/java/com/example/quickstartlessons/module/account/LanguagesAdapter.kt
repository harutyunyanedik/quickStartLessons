package com.example.quickstartlessons.module.account

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.LanguageItemBinding
import com.example.quickstartlessons.module.base.utils.QsConstants

class LanguagesAdapter(val onLanguageClick: (String) -> Unit): RecyclerView.Adapter<LanguagesAdapter.LanguageViewHolder>() {

    private val items = mutableListOf<Language>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var selectedPosition = QsConstants.NO_VALUE

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
    fun updateData(list: List<Language>?) {
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
                    onLanguageClick.invoke(items[adapterPosition].language)
                    selectedPosition = adapterPosition
                    notifyDataSetChanged()
                }
            }
        }
        fun bind(item: Language) {
            binding.textViewLanguage.text = item.language
            if (selectedPosition == adapterPosition){
                item.isSelected = android.R.color.holo_orange_light
            } else {
                item.isSelected = R.color.color_1_20
            }
            binding.constraintLayoutLanguage.background = ContextCompat.getDrawable(context, item.isSelected)
        }
    }
}