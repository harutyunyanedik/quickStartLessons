package com.example.quickstartlessons.module.base.utils

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.os.Build
import com.yariksoffice.lingver.Lingver
import java.util.Locale

object LocaleSwitcher {

    fun wrapContext(context: Context, newLocale: Locale): ContextWrapper {
        val config: Configuration = context.resources.configuration
        val sysLocale: Locale? = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            config.locales.get(0)
        } else {
            config.locale
        }
        if (newLocale.language != "" && !sysLocale?.language.equals(newLocale.language)) {
            Locale.setDefault(newLocale)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                config.setLocale(newLocale)
            } else {
                config.locale = newLocale
            }
        }
        var currentContext = context
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            currentContext = context.createConfigurationContext(config)
        } else {
            currentContext.resources.updateConfiguration(config, context.resources.displayMetrics)
        }
        return ContextWrapper(currentContext)
    }


    fun updateLocale(context: Context, newLocale: Locale) {
        if (newLocale.language == PreferencesManager.getCurrentLanguage()) return
        PreferencesManager.putCurrentLanguage(newLocale.language)
        Lingver.getInstance().setLocale(context, newLocale)
    }
}