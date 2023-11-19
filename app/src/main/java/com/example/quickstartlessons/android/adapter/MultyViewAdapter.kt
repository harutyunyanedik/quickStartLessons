package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.databinding.HeaderRecyclerViewBinding
import com.example.quickstartlessons.databinding.StandardRecycleViewBinding
import com.example.quickstartlessons.databinding.TextHeaderRecyclerViewBinding


class MultyViewAdapter : RecyclerView.Adapter<MultyViewAdapter.BaseViewHolder>() {
    private val item: MutableList<Model> = mutableListOf()
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        inflater = LayoutInflater.from(recyclerView.context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
       return when(viewType){
           STANDARD -> StandardMultiViewHolder(StandardRecycleViewBinding.inflate(inflater,parent,false))
           HEADER -> HeaderRecyclerViewHolder(HeaderRecyclerViewBinding.inflate(inflater,parent,false))
           TEXT_HEADER-> TextHeaderRecyclerHolder(TextHeaderRecyclerViewBinding.inflate(inflater,parent,false))
           else->  StandardMultiViewHolder(StandardRecycleViewBinding.inflate(inflater,parent,false))
       }
    }

    override fun getItemViewType(position: Int): Int {
        return when{
            item[position].textHeader != null && item[position].header == null -> TEXT_HEADER
            item[position].textHeader == null && item[position].header != null -> HEADER
            else -> STANDARD
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
       holder.bind(item[position])
    }


    override fun getItemCount() = item.size



    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<Model>?) {
        this.item.clear()
        item?.let {
            this.item.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        abstract fun bind(item:Model)
    }
    inner class HeaderRecyclerViewHolder(private val binding: HeaderRecyclerViewBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Model) {
            binding.headerTextView.text = item.header
        }
    }

    inner class TextHeaderRecyclerHolder(private val binding: TextHeaderRecyclerViewBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Model) {
            binding.titleTextView.text = item.textHeader
        }
    }
    inner class StandardMultiViewHolder(private val binding: StandardRecycleViewBinding) :
        BaseViewHolder(binding.root) {

        override fun bind(item: Model) {
            binding.title.text = item.title
        }


    }
        companion object {
            const val STANDARD: Int = 0
            const val HEADER: Int = 2
            const val TEXT_HEADER: Int = 1
        }
}