package com.ali.holyprays.mvp.model

import android.content.Context

class ModelSettingActivity(context: Context) {

    private val prefs =
        context.getSharedPreferences("SETTING_PREFERENCES", Context.MODE_PRIVATE).apply {
            if (!contains("PERSIAN_FONT_SIZE"))
                edit().putFloat("PERSIAN_FONT_SIZE", 16f).apply()
            if (!contains("ARABIC_FONT_SIZE"))
                edit().putFloat("ARABIC_FONT_SIZE", 16f).apply()
            if (!contains("IS_BOLD_TEXT"))
                edit().putBoolean("IS_BOLD_TEXT", false).apply()
            if (!contains("TEXT_FONT_RES_ID"))
                edit().putString("TEXT_FONT_RES_ID", "نبی").apply()
        }

    fun getPersianFontSize(): Float = prefs.getFloat("PERSIAN_FONT_SIZE", 16f)

    fun getArabicFontSize(): Float = prefs.getFloat("ARABIC_FONT_SIZE", 16f)

    fun getIsBoldText(): Boolean = prefs.getBoolean("IS_BOLD_TEXT", false)

    fun getFontResId(): String = prefs.getString("TEXT_FONT_RES_ID", "نبی")!!

}