package com.example.quickstartlessons.module.account

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSettingsBinding
import com.example.quickstartlessons.databinding.ItemBottomSheetBinding
import com.example.quickstartlessons.module.base.utils.QsConstants

class LanguageAdapter(private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<LanguageAdapter.BaseViewHolder>() {
    private lateinit var items: MutableList<String>
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var selectedPosition = QsConstants.NO_VALUE



    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return LanguageViewHolder(ItemBottomSheetBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataLanguages(list: List<String>) {
        this.items.clear()
        list.let {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: String)
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class LanguageViewHolder(private val binding: ItemBottomSheetBinding) : BaseViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClick.invoke(items[adapterPosition])
                    selectedPosition = adapterPosition
                    notifyDataSetChanged()
                }
            }
        }

        override fun bind(item: String) {
            binding.language.text = item
            val color = if (selectedPosition == adapterPosition) {
                R.color.color_red
            } else {
                R.color.white
            }
            binding.constraintLanguage.background = ContextCompat.getDrawable(context, color)
        }
    }
}
