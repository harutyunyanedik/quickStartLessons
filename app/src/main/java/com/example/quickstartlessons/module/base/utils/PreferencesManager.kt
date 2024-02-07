package com.example.quickstartlessons.module.base.utils


object PreferencesManager {

    private const val PREF_KEY_CURRENT_LANGUAGE = "pref_key_current_language"

    fun putCurrentLanguage(languageCode: String) = Prefs.put(PREF_KEY_CURRENT_LANGUAGE, languageCode)

    fun getCurrentLanguage() = Prefs.getString(PREF_KEY_CURRENT_LANGUAGE, "en") ?: "en"

    private const val KAY_USER_NAME="key_user_name"
    private const val KAY_USER_PASSWORD="key_user_password"

    fun putUserNameToPref(value: String) = Prefs.put(KAY_USER_NAME, value)

    fun putUserPasswordToPref(value: String) = Prefs.put(KAY_USER_PASSWORD, value)

    fun getUserNameFromPref() = Prefs.getString("key_user_name","")

    fun getUserPasswordFromPref() = Prefs.getString("key_user_password")
    fun removeUserName() = Prefs.remove(KAY_USER_NAME)
    fun removePassword() = Prefs.remove(KAY_USER_PASSWORD)
}