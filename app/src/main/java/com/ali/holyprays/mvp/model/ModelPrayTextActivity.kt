package com.ali.holyprays.mvp.model

import android.content.Context
import android.util.Log
import com.ali.holyprays.mvp.ext.PrefsManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ModelPrayTextActivity {

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

    fun saveDarkModeState(isDarkModeEnabled: Boolean) {
        PrefsManager.saveDarkModeState(isDarkModeEnabled)
    }

    fun getDarkModeState(): Boolean = PrefsManager.getDarkModeState()

    fun savePersianTranslationState(isPersianTranslationEnabled: Boolean) {
        PrefsManager.savePersianTranslationState(isPersianTranslationEnabled)
    }

    fun getPersianTranslationState(): Boolean = PrefsManager.getPersianTranslationState()

    fun saveTextSizeState(textSize: Float) {
        PrefsManager.saveTextSizeState(textSize)
    }

    fun getTextSizeState(): Float = PrefsManager.getTextSizeState()

}