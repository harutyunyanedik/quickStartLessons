package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ActivityTwoBinding
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding

class AdapterChildRecyclerView: RecyclerView.Adapter<AdapterChildRecyclerView.ChildViewHolder>() {
    private  val items:MutableList<ChildModel> = mutableListOf()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context=recyclerView.context
        inflater=LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
      return ChildViewHolder(ActivityTwoBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(items[position])

    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item:List<ChildModel>?){
        items.clear()
        item?.let {
            items.addAll(item)
            notifyDataSetChanged()
        }
    }
    inner class ChildViewHolder(private val item:ActivityTwoBinding):RecyclerView.ViewHolder(item.root){
        init {
            item.buttonSeeMore.setOnClickListener {
                if(item.buttonSeeMore.isPressed){

                }
            }
        }
       fun bind(binding:ChildModel){
           item.childText.text=binding.countryText

       }
    }
}
data class  ChildModel(val countryText:String, val button:Boolean)