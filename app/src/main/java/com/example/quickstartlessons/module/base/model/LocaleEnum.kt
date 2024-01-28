package com.example.quickstartlessons.module.base.model

import com.example.quickstartlessons.R

enum class LocaleEnum (val languageCode:String, var languageResId:Int){
    ENGLISH("en", R.string.english),
    RUSSIAN("ru",R.string.russian),
    ARMENIAN("hy",R.string.armenian)
}