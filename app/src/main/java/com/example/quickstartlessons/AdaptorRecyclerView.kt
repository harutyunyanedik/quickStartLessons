package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.contains
import androidx.core.view.get
import androidx.core.view.indices
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding

class AdaptorRecyclerView : RecyclerView.Adapter<AdaptorRecyclerView.RecyclerViewHolder>() {

    val list: MutableList<RvModel> = mutableListOf()

    lateinit var inflater: LayoutInflater
    lateinit var context: Context


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(ItemRecycleViewBinding.inflate(inflater, parent, false))

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<RvModel>?) {
        list.clear()
        item?.let {
            list.addAll(item)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged", "SuspiciousIndentation")


    inner class RecyclerViewHolder(private val item: ItemRecycleViewBinding) :
        RecyclerView.ViewHolder(item.root) {
           val childAdapter=AdapterChildRecyclerView()
        init {
            item.childRecyclerView.adapter=childAdapter
            item.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                  list[adapterPosition].arrow=!list[adapterPosition].arrow
                    notifyDataSetChanged()
                }
            }
        }
        fun bind(binding: RvModel) {
            item.countryname.text = binding.text
            item.count.text = binding.number.toString()
            val rotation = if (binding.arrow) 180f else 0f
            item.arrowDown.rotation = rotation
            Glide.with(item.countryflag).load(binding.image).into(item.countryflag)
            childAdapter.updateChildData(binding.newList)
             item.childRecyclerView.isVisible=binding.arrow
        }
    }
}

data class RvModel(val image:String,val text: String, val number: Int, var arrow: Boolean, val newList: List<Model>)