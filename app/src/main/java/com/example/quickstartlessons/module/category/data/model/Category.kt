package com.example.quickstartlessons.module.category.data.model

import com.example.quickstartlessons.R

data class Category(
    val category: String,
    var isSelected: Int = R.color.white
)