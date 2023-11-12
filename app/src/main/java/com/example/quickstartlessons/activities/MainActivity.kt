package com.example.quickstartlessons.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.adapters.CountriesAdapter
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.models.ChampionshipModel
import com.example.quickstartlessons.models.CountryModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val countriesAdapter = CountriesAdapter()
    private val championshipsName = listOf("MLS", "USL championship")
    private val countries = mutableMapOf<String, String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        createCountries()
        setAdapter()
    }

    private fun setAdapter() {
        with(binding){
            recyclerViewCountries.adapter = countriesAdapter
            recyclerViewCountries.layoutManager = LinearLayoutManager(this@MainActivity)
            countriesAdapter.updateCountriesList(createCountriesList())
        }
    }


    private fun createCountriesList(): List<CountryModel>{
        val countriesList = mutableListOf<CountryModel>()
        for (i in countries.keys){
            val countryChampionships = mutableListOf<ChampionshipModel>()
            for (j in 1 .. Random.nextInt(1, 5)){
                val position = Random.nextInt(0, championshipsName.size)
                countryChampionships.add(ChampionshipModel(championshipsName[position], false, Random.nextInt(1, 5)))
            }
            countriesList.add(CountryModel(
                countries[i]!!,
                i,
                Random.nextInt(1, 20),
                false,
                countryChampionships))
        }
        return countriesList
    }
    private fun createCountries(){
        countries["Armenia"] = "https://flagpedia.net/data/flags/w702/am.webp"
        countries["USA"] = "https://flagpedia.net/data/flags/w702/us.webp"
        countries["EU"] = "https://cdn-icons-png.flaticon.com/512/330/330426.png"
        countries["Canada"] = "https://flagpedia.net/data/flags/w702/ca.webp"
        countries["UK"] = "https://flagpedia.net/data/flags/w702/gb.webp"
        countries["France"] = "https://flagpedia.net/data/flags/w702/fr.webp"
        countries["Germany"] = "https://flagpedia.net/data/flags/w702/de.webp"
        countries["Italy"] = "https://flagpedia.net/data/flags/w702/it.webp"
        countries["Spain"] = "https://flagpedia.net/data/flags/w702/es.webp"
        countries["Mexico"] = "https://flagpedia.net/data/flags/w702/mx.webp"
        countries["Brazil"] = "https://flagpedia.net/data/flags/h80/br.webp"
        countries["Australia"] = "https://flagpedia.net/data/flags/h80/au.webp"
        countries["Ireland"] = "https://flagpedia.net/data/flags/h80/ie.webp"
        countries["Switzerland"] = "https://flagpedia.net/data/flags/h80/ch.webp"
        countries["Denmark"] = "https://flagpedia.net/data/flags/h80/dk.webp"
        countries["Greece"] = "https://flagpedia.net/data/flags/w702/gr.webp"
        countries["Israel"] = "https://flagpedia.net/data/flags/h80/il.webp"
        countries["Japan"] = "https://flagpedia.net/data/flags/h80/jp.webp"
        countries["South Korea"] = "https://flagpedia.net/data/flags/h80/kr.webp"
        countries["China"] = "https://flagpedia.net/data/flags/w702/cn.webp"
        countries["Sweden"] = "https://flagpedia.net/data/flags/h80/se.webp"
        countries["Czechia"] = "https://flagpedia.net/data/flags/h80/cz.webp"
        countries["Ukraine"] = "https://flagpedia.net/data/flags/h80/ua.webp"
    }
}