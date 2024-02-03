package com.example.quickstartlessons.module.base.utils

object PreferencesManager {

    private const val PREF_KEY_CURRENT_LANGUAGE = "pref_key_current_language"
    private const val USER_NAME = "pref_key_user_name" // todo rename USER_NAME to PREF_KEY_USERNAME
    private const val USER_PASSWORD = "pref_key_password"  // todo rename USER_PASSWORD to PREF_KEY_PASSWORD

    fun putTCurrentLanguage(languageCode: String) = Prefs.put(PREF_KEY_CURRENT_LANGUAGE, languageCode)
    fun getCurrentLanguage() = Prefs.getString(PREF_KEY_CURRENT_LANGUAGE, "en") ?: "en"


    fun putUserName(userName: String) = Prefs.put(USER_NAME, userName)
    fun getUserName() = Prefs.getString(USER_NAME)

    fun putUserPassword(password: String) = Prefs.put(USER_PASSWORD, password)
    fun getUserPassword() = Prefs.getString(USER_PASSWORD)
}