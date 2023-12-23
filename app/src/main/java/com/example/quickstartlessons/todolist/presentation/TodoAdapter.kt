package com.example.quickstartlessons.todolist.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.TodoItemBinding
import com.example.quickstartlessons.todolist.data.Todo

class TodoAdapter: RecyclerView.Adapter<TodoAdapter.BaseViewHolder>() {

    private val items = mutableListOf<Todo>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return TodoViewHolder(TodoItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view){
        abstract fun bind(item: Todo)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(list: List<Todo>?){
        items.clear()
        list?.let {
            items.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class TodoViewHolder(private val binding: TodoItemBinding): BaseViewHolder(binding.root){
        override fun bind(item: Todo) {
            binding.textViewTitle.text = item.title
            binding.textViewDescription.text = item.description
        }
    }
}