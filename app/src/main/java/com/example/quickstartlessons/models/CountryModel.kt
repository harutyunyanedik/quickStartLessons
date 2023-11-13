package com.example.quickstartlessons.models

data class CountryModel(
    val title: String,
    val image: String,
    val childItemList: List<ChildModel> = mutableListOf(),
    val isExpandable: Boolean = false

)