package com.example.quickstartlessons.practicalLesson

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentAddTextBinding

class AdapterAddText(private val onClick: (String) -> Unit) : RecyclerView.Adapter<AdapterAddText.ItemViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var items = mutableListOf<AddText>()

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
    fun updateAdapter(items: List<AddText>?) {
        this.items.clear()
        items?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }


    inner class ItemViewHolder(private val binding: FragmentAddTextBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.addButton.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onClick.invoke(items[adapterPosition].text)
                }
            }
        }

        fun bind(items: AddText) {
            binding.addText.text = items.text
        }
    }
}
