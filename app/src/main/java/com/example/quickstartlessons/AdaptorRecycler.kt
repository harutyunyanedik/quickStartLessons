package com.example.quickstartlessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.LessonAndroidRecylclerBinding

class AdaptorRecycler: RecyclerView.Adapter<AdaptorRecycler.HolderRecyclerView>() {
    private lateinit var context: Context
    private lateinit var  inflaterLesson: LayoutInflater

    inner class HolderRecyclerView(val binding:LessonAndroidRecylclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(view:String){
            binding.ArsenalFCSpecials.text=view
        }
    }
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context=recyclerView.context
        inflaterLesson=LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderRecyclerView {
        return HolderRecyclerView(LessonAndroidRecylclerBinding.inflate(inflaterLesson,parent,false))
    }

    override fun getItemCount(): Int=10

    override fun onBindViewHolder(holder: HolderRecyclerView, position: Int) {
        holder.bind(position.toString())
    }

}
