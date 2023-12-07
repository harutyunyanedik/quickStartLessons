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

class ItemAdapter(private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemFragmentViewHolder>() {

    private lateinit var context: Context
    private lateinit var inflater: LayoutInflater
    private var items = mutableListOf<ItemModel>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFragmentViewHolder {
        return ItemFragmentViewHolder(ItemTextBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemFragmentViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateAdapter(items: List<ItemModel>?) {
        this.items.clear()
        items?.let {
            this.items.addAll(it)
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

    @SuppressLint("NotifyDataSetChanged")
    inner class ItemFragmentViewHolder(private val binding: ItemTextBinding) :
        BaseViewHolder(binding.root) {

        init {
            binding.itemText.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onClick.invoke(items[adapterPosition].title)
                    showAlertDialog {
                        when {
                            true -> {
                                items.remove(ItemModel(items[adapterPosition].title))
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
}