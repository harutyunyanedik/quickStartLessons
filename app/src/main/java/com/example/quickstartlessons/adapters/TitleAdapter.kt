package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemTitleBinding
import com.example.quickstartlessons.models.RecyclerModel

class TitleAdapter : RecyclerView.Adapter<TitleAdapter.BaseViewHolder>() {

    private val items = mutableListOf<RecyclerModel>()
    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    var onItemClick: ((Boolean, RecyclerModel) -> Unit)? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return TitleViewHolder(ItemTitleBinding.inflate(inflater, parent, false))

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(items: List<RecyclerModel>?){
        this.items.clear()
        items?.let {
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(item: RecyclerModel){
        items.remove(item)
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: RecyclerModel)
    }

    inner class TitleViewHolder(private val binding: ItemTitleBinding) :
        BaseViewHolder(binding.root) {

        init {
            binding.root.setOnLongClickListener {
                val alertDialogBuilder = AlertDialog.Builder(context)

                alertDialogBuilder.setTitle("Confirmation")
                alertDialogBuilder.setMessage("Are you want to delete this item?")

                alertDialogBuilder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                    onItemClick?.invoke(true, items[adapterPosition])
                }
                alertDialogBuilder.setNegativeButton("No") { _: DialogInterface, _: Int ->
                    onItemClick?.invoke(false, items[adapterPosition])
                }

                val alertDialog: AlertDialog = alertDialogBuilder.create()
                if (!alertDialog.isShowing) {
                    alertDialog.show()
                }
                true
            }
        }

        override fun bind(item: RecyclerModel) {
            binding.textViewTitle.text = item.title
        }
    }
}