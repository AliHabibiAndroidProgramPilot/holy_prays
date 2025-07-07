package com.ali.holyprays.mvp.model

import android.content.Context
import com.ali.holyprays.R

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
                edit().putInt("TEXT_FONT_RES_ID", R.font.nabi).apply()
        }

    fun getPersianFontSize(): Float = prefs.getFloat("PERSIAN_FONT_SIZE", 16f)

    fun getArabicFontSize(): Float = prefs.getFloat("ARABIC_FONT_SIZE", 16f)

    fun getIsBoldText(): Boolean = prefs.getBoolean("IS_BOLD_TEXT", false)

    fun getFontResId(): Int = prefs.getInt("TEXT_FONT_RES_ID", 0)

    fun savePersianFontSize(fontSize: Float) {
        prefs.edit()
            .putFloat("PERSIAN_FONT_SIZE", fontSize)
            .apply()
    }

    fun saveArabicFontSize(fontSize: Float) {
        prefs.edit()
            .putFloat("ARABIC_FONT_SIZE", fontSize)
            .apply()
    }

    fun saveIsTextBolded(isBold: Boolean) {
        prefs.edit()
            .putBoolean("IS_BOLD_TEXT", isBold)
            .apply()
    }

    fun saveFontResId(resId: Int) {
        prefs.edit()
            .putInt("TEXT_FONT_RES_ID", resId)
            .apply()
    }

}