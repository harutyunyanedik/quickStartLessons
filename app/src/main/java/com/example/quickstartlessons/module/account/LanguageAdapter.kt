package com.example.quickstartlessons.module.account

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentSettingsBinding
class LanguageAdapter(private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<LanguageAdapter.BaseViewHolder>() {
    private lateinit var items: MutableList<String>
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return LanguageViewHolder(FragmentSettingsBinding.inflate(inflater, parent, false))
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

    inner class LanguageViewHolder(private val binding: FragmentSettingsBinding) : BaseViewHolder(binding.root) {
        init {
            binding.appLanguage.setOnClickListener {
                    onItemClick.invoke(items[adapterPosition])
            }
        }

        override fun bind(item: String) {
            binding.appLanguage.text = item
        }
    }
}
