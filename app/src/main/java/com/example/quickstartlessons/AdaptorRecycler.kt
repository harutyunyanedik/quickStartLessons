package com.example.quickstartlessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding


class AdaptorRecycler(private val onItemCheck:(Int)->Unit) : RecyclerView.Adapter<AdaptorRecycler.RecyclerVewHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    val list  = mutableListOf<RvModel>()

    inner class RecyclerVewHolder(private val item: ItemRecycleViewBinding) :
        RecyclerView.ViewHolder(item.root) {
        init {
            item.buttonView.setOnCheckedChangeListener { button, isChecked ->
                if (button.isPressed) {
                    if (adapterPosition != RecyclerView.NO_POSITION)
                        list[adapterPosition].checkbutton = isChecked
                }
            }
            item.rootlayout.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    item.textnovisible.isVisible=!item.textnovisible.isVisible
                    onItemCheck.invoke(adapterPosition)
                    notifyItemChanged(adapterPosition)
                }

            }
        }
        fun bind(position: RvModel) {
            item.textrecycler.text = position.text
            item.textnovisible.isVisible = false
            item.buttonView.isChecked = position.checkbutton

        }
    }
         fun apdateData(item: List<RvModel>){
             list.clear()
              item?.let {
                 this.list.addAll(item)
              }
              notifyDataSetChanged()
          }
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerVewHolder {
        return RecyclerVewHolder(ItemRecycleViewBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerVewHolder, position: Int) {
        holder.bind(list[position])

    }
}

data class RvModel(var checkbutton: Boolean, val text: String, val textnovisblity: Boolean)