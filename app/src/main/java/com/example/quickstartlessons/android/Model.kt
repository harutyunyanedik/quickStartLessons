package com.example.quickstartlessons.android

data class Model (val image:String,
                  val title:String,
                  var number:String,
                  val itemList1: List<CountryModel> = mutableListOf(),
                  var isExpanded:Boolean=false)
