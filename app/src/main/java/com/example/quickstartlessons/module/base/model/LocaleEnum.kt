package com.example.quickstartlessons.module.base.model

import com.example.quickstartlessons.R

enum class LocaleEnum(val languageCode: String, val languageResId: Int) {
    ENGLISH("en", R.string.english),
    RUSSIAN("ru", R.string.russian),
    ARMENIAN("hy", R.string.armenian);

    companion object {
        private val map = values().associateBy(LocaleEnum::languageCode)
        fun from(value: String) = map[value] ?: ENGLISH
    }
}