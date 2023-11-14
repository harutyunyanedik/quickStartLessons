package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ActivityTwoBinding

class AdapterChildRecyclerView: RecyclerView.Adapter<AdapterChildRecyclerView.RecyclerViewChildHolder>() {
    val childList: MutableList<Model> = mutableListOf()
 lateinit var context: Context
 lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context=recyclerView.context
        inflater=LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewChildHolder {
        return RecyclerViewChildHolder(ActivityTwoBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount()=childList.size

    override fun onBindViewHolder(holder: RecyclerViewChildHolder, position: Int) {
       holder.bind(childList[position])
    }
    fun updateChildData(child: List<Model>?) {
        childList.clear()
        child?.let {
            childList.addAll(child)
        }
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    inner class RecyclerViewChildHolder(private val item:ActivityTwoBinding):RecyclerView.ViewHolder(item.root){
        init {

            item.checkbox.setOnCheckedChangeListener{button, isChecked->
                if(button.isPressed){
                    if (adapterPosition!=RecyclerView.NO_POSITION){
                      childList[adapterPosition].checkbox=isChecked
                        notifyDataSetChanged()
                    }
                }
            }
        }
         fun bind(items:Model){
             item.titlename.text=items.name
             item.checkbox.isChecked=items.checkbox
             item.number.text=items.numberChild.toString()

         }
    }
}
data class Model(var checkbox: Boolean, var name: String,var numberChild:Int)