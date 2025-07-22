package com.ali.holyprays.mvp.model

import android.content.Context
import android.content.SharedPreferences
import com.ali.holyprays.provider.PrayReciters
import com.ali.holyprays.provider.SoreReciters

class ModelSettingActivity(context: Context) {

    private val prefsManager: SharedPreferences =
        context.getSharedPreferences("SETTING_PREFERENCES", Context.MODE_PRIVATE)

    fun getPersianFontSize(): Float = prefsManager.getFloat("PERSIAN_FONT_SIZE", 16f)

    fun getArabicFontSize(): Float = prefsManager.getFloat("ARABIC_FONT_SIZE", 16f)

    fun getIsBoldText(): Boolean = prefsManager.getBoolean("IS_BOLD_TEXT", false)

    fun getFontResId(): Int = prefsManager.getInt("TEXT_FONT_RES_ID", 0)

    fun getSelectedQuranReciter(): String =
        prefsManager.getString(
            "SELECTED_QURAN_RECITER",
            SoreReciters.ABDOL_VASET.reciterDisplayName
        ) ?: SoreReciters.ABDOL_VASET.reciterDisplayName

    fun getSelectedPrayReciter(): String =
        prefsManager.getString(
            "SELECTED_PRAY_RECITER",
            PrayReciters.MOHSEN_FARAHMAND.reciterDisplayName
        ) ?: PrayReciters.MOHSEN_FARAHMAND.reciterDisplayName

    fun savePersianFontSize(fontSize: Float) {
        prefsManager.edit()
            .putFloat("PERSIAN_FONT_SIZE", fontSize)
            .apply()
    }

    fun saveArabicFontSize(fontSize: Float) {
        prefsManager.edit()
            .putFloat("ARABIC_FONT_SIZE", fontSize)
            .apply()
    }

    fun saveIsTextBolded(isBold: Boolean) {
        prefsManager.edit()
            .putBoolean("IS_BOLD_TEXT", isBold)
            .apply()
    }

    fun saveFontResId(resId: Int) {
        prefsManager.edit()
            .putInt("TEXT_FONT_RES_ID", resId)
            .apply()
    }

    fun saveSelectedQuranReciter(selectedReciterName: String) {
        prefsManager.edit()
            .putString("SELECTED_QURAN_RECITER", selectedReciterName)
            .apply()
    }

    fun saveSelectedPrayReciter(selectedReciterName: String) {
        prefsManager.edit()
            .putString("SELECTED_PRAY_RECITER", selectedReciterName)
            .apply()
    }

}