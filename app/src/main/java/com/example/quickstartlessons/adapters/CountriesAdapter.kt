package com.example.quickstartlessons.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.CountryItemBinding
import com.example.quickstartlessons.models.CountryModel

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val countriesList = mutableListOf<CountryModel>()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(CountryItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(countriesList[position])
    }

    override fun getItemCount(): Int = countriesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateCountriesList(item: List<CountryModel>?) {
        countriesList.clear()
        item?.let {
            countriesList.addAll(it)
        }
        notifyDataSetChanged()
    }


    inner class CountriesViewHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val adapter = ChampionshipsAdapter()
        init {
            binding.recyclerViewChampionships.adapter = adapter

            binding.layoutCountry.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    countriesList[adapterPosition].isExpanded =
                        !countriesList[adapterPosition].isExpanded
                    notifyItemChanged(adapterPosition)
                }
            }
        }

        fun bind(model: CountryModel) {
            with(binding) {
                Glide.with(imageViewFlag).load(model.countryFlagUrl).into(imageViewFlag)
                textViewCountryName.text = model.countryName
                textViewCount.text = model.count.toString()
                val rotation = if (model.isExpanded) 180f else 0f
                imageViewArrowDown.rotation = rotation
                recyclerViewChampionships.isVisible = model.isExpanded
                adapter.updateList(model.championship)
                val linearLayoutManager = LinearLayoutManager(binding.recyclerViewChampionships.context)
                recyclerViewChampionships.layoutManager = linearLayoutManager


            }
        }
    }
}