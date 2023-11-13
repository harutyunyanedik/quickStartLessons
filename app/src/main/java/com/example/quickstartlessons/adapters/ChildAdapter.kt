package com.example.quickstartlessons.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.models.ChildModel

class ChildAdapter(private val childList: List<ChildModel>):RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {


    inner class ChildViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val title: TextView = itemView.findViewById(R.id.childTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_item,parent,false)
        return ChildViewHolder(view)
    }

    override fun getItemCount() : Int{
        return childList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.title.text = childList[position].title
    }


}
