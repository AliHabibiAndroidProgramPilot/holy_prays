package com.ali.holyprays.mvp.model

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ModelPrayTextActivity(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("SETTING_PREFERENCES", Context.MODE_PRIVATE)

    suspend fun readPrayTextFileFromAsset(context: Context, filePath: String): List<String> {
        return withContext(Dispatchers.IO) {
            try {
                context.assets.open(filePath)
                    .bufferedReader()
                    // use Ensures That BufferReader Resources Are Closed Manually By System!
                    .use { it.readText() }
                    .split("##PART##")
                    .map { it.trim() }
                    .filter { it.isNotEmpty() }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("EXCEPTION", e.message ?: "null message")
                emptyList()
            }
        }
    }

    suspend fun readPrayPersianTranslationFileFromAsset(
        context: Context,
        filePath: String
    ): List<String> {
        return withContext(Dispatchers.IO) {
            try {
                context.assets.open(filePath)
                    .bufferedReader()
                    // use Ensures That BufferReader Resources Are Closed Manually By System!
                    .use { it.readText() }
                    .split("##PART##")
                    .map { it.trim() }
                    .filter { it.isNotEmpty() }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("EXCEPTION", e.message ?: "null message")
                emptyList()
            }
        }
    }

    fun getPersianFontSize(): Float = prefs.getFloat("PERSIAN_FONT_SIZE", 16f)

    fun getArabicFontSize(): Float = prefs.getFloat("ARABIC_FONT_SIZE", 16f)

    fun getIsBoldText(): Boolean = prefs.getBoolean("IS_BOLD_TEXT", false)

    fun getFontResId(): Int = prefs.getInt("TEXT_FONT_RES_ID", 0)

}