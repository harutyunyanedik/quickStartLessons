package com.example.quickstartlessons.module.base.utils

object PreferencesManager {

    private const val PREF_KEY_CURRENT_LANGUAGE = "pref_key_current_language"

    fun putCurrentLanguage(languageKey: String) = Prefs.put(PREF_KEY_CURRENT_LANGUAGE, languageKey)

    fun getCurrentLanguage() = Prefs.getString(PREF_KEY_CURRENT_LANGUAGE, "en") ?: "en"

}