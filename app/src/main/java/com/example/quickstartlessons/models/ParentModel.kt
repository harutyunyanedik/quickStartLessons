package com.example.quickstartlessons.models

data class ParentModel(
    val title: String,
    val image: Int,
    val childItemList: ArrayList<ChildModel>,
    val isexpandable: Boolean = false

)