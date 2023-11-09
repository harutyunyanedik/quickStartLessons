package com.example.quickstartlessons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FavoriteItemBinding

class FavoriteItemsAdapter(val onFavoriteItemClick: (Int) -> Unit,
    ) : RecyclerView.Adapter<FavoriteItemsAdapter.FavoriteItemViewHolder>() {

    private val items = mutableListOf<FavoriteItemModel>()
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    var onFavoriteTextViewClick: ((Int) -> Unit)? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteItemViewHolder {
        return FavoriteItemViewHolder(FavoriteItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteItemViewHolder, position: Int) {
        holder.bind(items[position])

    }


    override fun getItemCount(): Int {
        return items.size
    }


    fun updateData(list: List<FavoriteItemModel>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class FavoriteItemViewHolder(val binding: FavoriteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.checkboxFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
                items[adapterPosition].isFavorite = isChecked
            }
            binding.rootLayout.setOnClickListener {
                onFavoriteItemClick.invoke(adapterPosition)
            }
            binding.textViewTitle.setOnClickListener {
                when(items[adapterPosition].isVisible){
                    1 -> items[adapterPosition].isVisible = 0
                    0 -> items[adapterPosition].isVisible = 1
                }
                notifyDataSetChanged()
            }
        }
        fun bind(model: FavoriteItemModel) {
            binding.textViewTitle.text = model.title
            binding.checkboxFavorite.isChecked = model.isFavorite
            when(model.isVisible){
                0 -> binding.imageView.visibility = View.GONE
                1 -> binding.imageView.visibility = View.VISIBLE
            }
        }
    }
}