package com.example.quickstartlessons.module.base.utils

object PreferencesManager {

    private const val PREF_KEY_CURRENT_LANGUAGE = "pref_key_current_language"
    private const val PREF_KEY_CURRENT_USERNAME = "pref_key_current_username"
    private const val PREF_KEY_CURRENT_PASSWORD = "pref_key_current_password"
    fun putCurrentLanguage(languageCode: String) = Prefs.put(PREF_KEY_CURRENT_LANGUAGE, languageCode)
    fun getCurrentLanguage() = Prefs.getString(PREF_KEY_CURRENT_LANGUAGE, "en") ?: "en"

    fun putCurrentUserName(userName: String?) = Prefs.put(PREF_KEY_CURRENT_USERNAME, userName)
    fun putCurrentPassword(password: String?) = Prefs.put(PREF_KEY_CURRENT_PASSWORD, password)
    fun getCurrentUserName() = Prefs.getString(PREF_KEY_CURRENT_USERNAME, null)
    fun getCurrentPassword() = Prefs.getString(PREF_KEY_CURRENT_PASSWORD, null)
}