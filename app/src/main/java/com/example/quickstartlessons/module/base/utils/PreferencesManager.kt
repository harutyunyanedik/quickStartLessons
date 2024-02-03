package com.example.quickstartlessons.module.base.utils

object PreferencesManager {

    private const val PREF_KEY_CURRENT_LANGUAGE = "pref_key_current_language"

    fun putTCurrentLanguage(languageCode: String) = Prefs.put(PREF_KEY_CURRENT_LANGUAGE, languageCode)

    fun getCurrentLanguage() = Prefs.getString(PREF_KEY_CURRENT_LANGUAGE, "en") ?:"en"

    private const val USER_NAME="pref_key_user_name"
    private const val USER_PASSWORD="pref_key_user_name"
    fun putUserName(userName:String)=Prefs.put(USER_NAME,userName)
    fun putUserPassword(password:String)=Prefs.put(USER_PASSWORD,password)
    fun getUserName()=Prefs.getString(USER_NAME)
    fun getUserPassword()=Prefs.getString(USER_PASSWORD)
}