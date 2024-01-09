package com.example.quickstartlessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.LayoutRecyclerBinding

class RecyclerAdaptor: RecyclerView.Adapter<RecyclerAdaptor.ViewRecyclerHolder>() {
       lateinit var inflater:LayoutInflater
       lateinit var context:Context
        private val list:MutableList<NewParametr> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context=recyclerView.context
        inflater=LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewRecyclerHolder {
          return  ViewRecyclerHolder(LayoutRecyclerBinding.inflate(inflater,parent,false))

    }
    override fun getItemCount(): Int =list.size
    override fun onBindViewHolder(holder: ViewRecyclerHolder, position: Int) {
        holder.bind(list[position])
    }
    fun itemData(items:List<NewParametr>?){
        this.list.clear()
        items?.let {
            this.list.addAll(items)
        }
        notifyDataSetChanged()
    }
    inner class ViewRecyclerHolder(private val binding:LayoutRecyclerBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position:NewParametr) {
            binding.recyclerText.text= position.value1
            binding.recyclerText2.text=position.values2
        }
    }

}
data class NewParametr(val value1:String, val values2:String)