package com.ali.holyprays.mvp.ext

import android.content.Context
import android.content.SharedPreferences

object PrefsManager {

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.applicationContext.getSharedPreferences(
            "USER_PREFERENCES",
            Context.MODE_PRIVATE
        )
    }

    fun saveDarkModeState(isDarkModeEnabled: Boolean) {
        prefs.edit().putBoolean("USER_PREFERENCES_DARK_MODE", isDarkModeEnabled).apply()
    }

    fun getDarkModeState(): Boolean = prefs.getBoolean("USER_PREFERENCES_DARK_MODE", false)

    fun savePersianTranslationState(isPersianTranslationEnabled: Boolean) {
        prefs.edit()
            .putBoolean("USER_PREFERENCES_PERSIAN_TRANSLATION_ENABLED", isPersianTranslationEnabled)
            .apply()
    }

    fun getPersianTranslationState(): Boolean =
        prefs.getBoolean("USER_PREFERENCES_PERSIAN_TRANSLATION_ENABLED", false)

    fun saveTextSizeState(textSize: Float) {
        prefs.edit().putFloat("USER_PREFERENCES_TEXT_SIZE", textSize).apply()
    }

    fun getTextSizeState(): Float = prefs.getFloat("USER_PREFERENCES_TEXT_SIZE", 14f)
}