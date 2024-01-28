package com.example.quickstartlessons.module.base.utils

import android.content.Context
import com.yariksoffice.lingver.Lingver
import java.util.Locale

object LocaleSwitcher {
    fun updateLocale(context: Context, newLocale:Locale){
       if(newLocale.language == PreferencesManager.getCurrentLanguage())  return
        PreferencesManager.putCurrentLanguage(newLocale.language)
        Lingver.getInstance().setLocale(context,newLocale)
    }
}