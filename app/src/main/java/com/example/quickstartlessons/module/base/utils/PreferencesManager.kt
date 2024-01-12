package com.example.quickstartlessons.module.base.utils

object PreferencesManager {

    private const val PREF_KEY_TEST = "pref_key_test"

    fun putTest(isShow: Boolean) = Prefs.put(PREF_KEY_TEST, isShow)

    fun isTest() = Prefs.getBoolean(PREF_KEY_TEST, false)

}