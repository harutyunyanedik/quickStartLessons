package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.databinding.ViewFragmentRootBinding
import java.util.zip.Inflater

class AdapterRootFragment(private val onClick: (Model) -> Unit) :
    RecyclerView.Adapter<AdapterRootFragment.RootFragmentViewHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items = mutableListOf<Model>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RootFragmentViewHolder {
        return RootFragmentViewHolder(ViewFragmentRootBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: RootFragmentViewHolder, position: Int) {
        holder.bind(items[position])
    }

    abstract class Base(itemView: View) : RecyclerView.ViewHolder(itemView) {
        open fun bind(item: Model) {

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<Model>?) {
        items.clear()
        item?.let {
            items.addAll(item)
            notifyDataSetChanged()
        }
    }

    fun showAlertDialog(onItemClick: (Boolean) -> Unit) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle("Confirmation")
        alertDialogBuilder.setMessage("Do you want to delete the text?")

        alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
            onItemClick.invoke(true)
        }
        alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
            onItemClick(false)
        }

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        if (!alertDialog.isShowing) {
            alertDialog.show()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class RootFragmentViewHolder(private val binding: ViewFragmentRootBinding) :
        Base(binding.root) {
        init {
            binding.description.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onClick.invoke(items[adapterPosition])
                    notifyDataSetChanged()

                }
            }
        }


        override fun bind(item: Model) {
            binding.description.text = item.title

        }
    }

    companion object {
        const val STANDARD = 1

    }
}