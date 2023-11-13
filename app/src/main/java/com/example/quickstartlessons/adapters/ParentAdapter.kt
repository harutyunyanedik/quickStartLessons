package com.example.quickstartlessons.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R

class ParentAdapter(private val parentItemList:List<ParentAdapter>)
    :RecyclerView.Adapter<ParentAdapter.ParentRecyclerViewHolder>(){


    inner class ParentRecyclerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    val parentImageView: ImageView = itemView.findViewById(R.id.flagImage)
    val parentTitle: TextView = itemView.findViewById(R.id.countryName)
    val childRecyclerView: RecyclerView = itemView.findViewById(R.id.subItem)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item,parent,false)
        return ParentRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parentItemList.size
    }

    override fun onBindViewHolder(holder: ParentRecyclerViewHolder, position: Int) {


}
    }