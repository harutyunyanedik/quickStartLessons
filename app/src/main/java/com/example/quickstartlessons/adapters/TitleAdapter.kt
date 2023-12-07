package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemTitleBinding
import com.example.quickstartlessons.models.RecyclerModel

class TitleAdapter : RecyclerView.Adapter<TitleAdapter.BaseViewHolder>() {

    private val items = mutableListOf<RecyclerModel>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    var onItemClick: ((RecyclerModel) -> Unit)? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return TitleViewHolder(ItemTitleBinding.inflate(inflater, parent, false))

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(items: List<RecyclerModel>?){
        this.items.clear()
        items?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(item: RecyclerModel){
        items.remove(item)
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: RecyclerModel)
    }

    inner class TitleViewHolder(private val binding: ItemTitleBinding) :
        BaseViewHolder(binding.root) {

        init {
            binding.root.setOnLongClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION){
                    onItemClick?.invoke(items[adapterPosition])
                }
                true
            }
        }

        override fun bind(item: RecyclerModel) {
            binding.textViewTitle.text = item.title
        }
    }
}