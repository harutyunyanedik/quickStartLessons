package com.example.quickstartlessons.practicalLesson

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentAddTextBinding

class AdapterAddText : RecyclerView.Adapter<AdapterAddText.ItemViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var items = mutableListOf<AddTextData>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(FragmentAddTextBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(item: List<AddTextData>?) {
        this.items.clear()
        item?.let {
            items.addAll(item)
        }
        notifyDataSetChanged()
    }


    inner class ItemViewHolder(private val binding: FragmentAddTextBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: AddTextData) {
            binding.addText.text = items.text
        }
    }
}
