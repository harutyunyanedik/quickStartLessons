package com.example.quickstartlessons.models

data class CountryModel(
    val countryFlagUrl: String,
    val countryName: String,
    val count: Int,
    var isExpanded: Boolean,
    val championship: List<ChampionshipModel>
)