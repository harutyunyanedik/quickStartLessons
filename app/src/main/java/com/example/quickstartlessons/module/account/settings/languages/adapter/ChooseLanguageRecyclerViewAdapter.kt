package com.example.quickstartlessons.module.account.settings.languages.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.RvChooseLanguageBinding


class ChooseLanguageRecyclerViewAdapter(private var onItemClick: (String) -> Unit) : RecyclerView.Adapter<ChooseLanguageRecyclerViewAdapter.BaseViewHolder>() {
    private val items: MutableList<String> = mutableListOf()
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
    fun updateData(item: List<String>?) {
        this.items.clear()
        item?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: String)
    }

    inner class ChooseLanguageRecyclerViewHolder(private val binding: RvChooseLanguageBinding) : BaseViewHolder(binding.root) {
        init {
            binding.languages.setOnClickListener {
                onItemClick.invoke(items[adapterPosition])
            }
        }

        override fun bind(item: String) {
            binding.languages.text = item.toString()
        }
    }
}