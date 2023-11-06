package com.example.quickstartlessons.kotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class FirstRecyclerAdapter:RecyclerView.Adapter<FirstRecyclerAdapter.FirstRecyclerViewHolder>() {
    lateinit var inflater: LayoutInflater
    lateinit var context:Context
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context=recyclerView.context
        inflater=LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstRecyclerViewHolder {
        return FirstRecyclerViewHolder()
    }



    override fun onBindViewHolder(holder: FirstRecyclerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int =100

    inner class FirstRecyclerViewHolder(view:RecyclerView ) :
        RecyclerView.ViewHolder(view.rootView) {

    }
}