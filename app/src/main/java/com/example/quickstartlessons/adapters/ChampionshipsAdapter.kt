package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.ChampionshipItemBinding
import com.example.quickstartlessons.models.ChampionshipModel

class ChampionshipsAdapter(): RecyclerView.Adapter<ChampionshipsAdapter.ChampionshipViewHolder>() {

    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val championships = mutableListOf<ChampionshipModel>()



    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionshipViewHolder {
        return ChampionshipViewHolder(ChampionshipItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ChampionshipViewHolder, position: Int) {
        holder.bind(championships[position])
    }

    override fun getItemCount(): Int = championships.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(item: List<ChampionshipModel>?){
        championships.clear()
        item?.let {
            championships.addAll(it)
            notifyDataSetChanged()
        }

    }



    inner class ChampionshipViewHolder(private val binding: ChampionshipItemBinding): RecyclerView.ViewHolder(binding.root){

        init {
            binding.checkboxFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
                if (adapterPosition != RecyclerView.NO_POSITION){
                    championships[adapterPosition].isFavorite = isChecked
                }
            }
        }

        fun bind(model: ChampionshipModel){
            binding.textViewChampionshipName.text = model.championshipName
            binding.textViewChampionshipCount.text = model.championshipCount.toString()
            binding.checkboxFavorite.isChecked = model.isFavorite
        }

    }
}