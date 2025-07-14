package com.ali.holyprays.mvp.model

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ModelPrayTextActivity(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("SETTING_PREFERENCES", Context.MODE_PRIVATE)

    private var mediaPlayer: MediaPlayer? = null

    private var isMediaPlayerPrepared = false

    private var wasMediaPlayerPLaying = false

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

    fun playPrayAudio(audioUri: String, onResult: (success: Boolean) -> Unit) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer()
            isMediaPlayerPrepared = false
            try {
                mediaPlayer?.setDataSource(audioUri)
                mediaPlayer?.prepareAsync()
                mediaPlayer?.isLooping = false
                mediaPlayer?.setOnErrorListener { _, _, _ ->
                    Log.i("MEDIA_PLAYER", "PLAYING_ERROR")
                    wasMediaPlayerPLaying = false
                    isMediaPlayerPrepared = false
                    onResult(false)
                    return@setOnErrorListener true
                }
                mediaPlayer?.setOnPreparedListener {
                    it.start()
                    wasMediaPlayerPLaying = true
                    isMediaPlayerPrepared = true
                    onResult(true)
                }
                mediaPlayer!!.setOnCompletionListener {
                    wasMediaPlayerPLaying = false
                    isMediaPlayerPrepared = false
                }
            } catch (e: Exception) {
                Log.e("MEDIA_PLAYER", "Exception: ${e.message}")
                onResult(false)
            }
        } else {
            mediaPlayer?.start()
            wasMediaPlayerPLaying = true
            onResult(true)
        }
    }

    fun playPrayAudio(context: Context, audioResId: Int) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, audioResId)
            mediaPlayer?.start()
            isMediaPlayerPrepared = false
            wasMediaPlayerPLaying = false
        } else {
            mediaPlayer?.start()
            isMediaPlayerPrepared = true
            wasMediaPlayerPLaying = true
        }
    }

    fun audioSeekTo(durationPosition: Int) {
        mediaPlayer?.seekTo(durationPosition)
    }

    fun saveCurrentPosition(): Int? {
        return if (mediaPlayer != null && mediaPlayer!!.isPlaying)
            mediaPlayer?.currentPosition
        else
            null
    }

    val stopPrayAudio: () -> Boolean = {
        mediaPlayer?.pause()
        mediaPlayer?.isPlaying ?: false
    }

    val releaseMediaPlayer: () -> Unit = {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun isMediaPlayerAlreadyPrepared(): Boolean = isMediaPlayerPrepared

    fun getPersianFontSize(): Float = prefs.getFloat("PERSIAN_FONT_SIZE", 16f)

    fun getArabicFontSize(): Float = prefs.getFloat("ARABIC_FONT_SIZE", 16f)

    fun getIsBoldText(): Boolean = prefs.getBoolean("IS_BOLD_TEXT", false)

    fun getFontResId(): Int = prefs.getInt("TEXT_FONT_RES_ID", 0)

    fun getSelectedReciter(): String =
        prefs.getString("SELECTED_RECITER", "عبدالباسط") ?: "عبدالباسط"

}