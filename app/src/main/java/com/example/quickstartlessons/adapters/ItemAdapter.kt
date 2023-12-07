package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ItemTextBinding
import com.example.quickstartlessons.models.ItemModel

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemFragmentViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var item = mutableListOf<ItemModel>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFragmentViewHolder {
        return ItemFragmentViewHolder(ItemTextBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ItemFragmentViewHolder, position: Int) {
        holder.bind(item[position])
    }

    fun updateAdapter(items: List<ItemModel>?) {
        this.item.clear()
        items?.let {
            this.item.addAll(it)
        }

    }

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        open fun bind() {

        }
    }

    fun showAlertDialog(onItemClick: (Boolean) -> Unit) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle("Confirmation")
        alertDialogBuilder.setMessage("Are you want to delete this item")

        alertDialogBuilder.setPositiveButton("YES") { _: DialogInterface, _: Int ->
            onItemClick.invoke(true)

        }
        alertDialogBuilder.setNegativeButton("NO") { _: DialogInterface, _: Int ->
            onItemClick.invoke(false)

        }

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        if (!alertDialog.isShowing) {
            alertDialog.show()
        }
    }

    inner class ItemFragmentViewHolder(private val binding: ItemTextBinding) :
        BaseViewHolder(binding.root) {

        init {
            binding.itemText.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
//                    onClick.invoke(item[adapterPosition].title)
                    showAlertDialog {
                        when {
                            true -> {
                                item.remove(ItemModel(item[adapterPosition].title))
                                notifyDataSetChanged()
                            }

                            false -> notifyDataSetChanged()
                        }
                    }
                }
            }
        }

        fun bind(items: ItemModel) {
            binding.itemText.text = items.title
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(index: Int) {
        item.removeAt(index)
        notifyDataSetChanged()
    }


}