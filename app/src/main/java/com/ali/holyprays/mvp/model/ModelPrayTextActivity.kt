package com.ali.holyprays.mvp.model

import android.content.Context
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.FileNotFoundException

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
            } catch (e: FileNotFoundException) {
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
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Log.e("EXCEPTION", e.message ?: "null message")
                emptyList()
            }
        }
    }

}