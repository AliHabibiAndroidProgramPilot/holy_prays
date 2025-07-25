package com.ali.holyprays.mvp.presenter

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelPrayTextActivity
import com.ali.holyprays.mvp.view.ViewPrayTextActivity
import com.ali.holyprays.provider.PrayCategories
import com.ali.holyprays.provider.PrayReciters
import com.ali.holyprays.provider.SoreReciters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PresenterPrayTextActivity(
    private val view: ViewPrayTextActivity,
    private val model: ModelPrayTextActivity,
    private val utils: ActivityUtils
) : ActivityLifecycle {

    private val job = Job()

    private val scope = CoroutineScope(Dispatchers.IO + job)

    private val handler = Handler(Looper.getMainLooper())

    private var updateSeekRunnable: Runnable = Runnable {}

    private var savedAudioPosition: Int? = null

    private var savedQuranReciter: String? = null

    private var savedPrayReciter: String? = null

    override fun presenterOnCreate() {
        view.setInsetsAndUiColor()
        providePrayText(view.provideFilesPath(), view.providePrayPersianTranslationFilePath())
        view.navigationBackClickHandler()
        view.navigationToSettingActivity()
        view.playPrayAudioManager()
    }

    override fun presenterOnPause() {
        model.stopPrayAudio()
        view.onPauseMediaPlayerForceStop()
        savedAudioPosition = model.saveCurrentPosition()
        savedQuranReciter = model.getSelectedQuranReciter()
        savedPrayReciter = model.getSelectedPrayReciter()
    }

    override fun presenterOnResume() {
        view.invalidateRecycler(
            model.getPersianFontSize(),
            model.getArabicFontSize(),
            model.getIsBoldText(),
            model.getFontResId()
        )
        when (view.providePrayCategory()) {
            PrayCategories.SORE -> {
                if (model.getSelectedQuranReciter() == savedQuranReciter) {
                    if (savedAudioPosition != null)
                        model.audioSeekTo(savedAudioPosition!!)
                } else
                    model.releaseMediaPlayer()
            }

            else -> {
                if (model.getSelectedPrayReciter() == savedPrayReciter) {
                    if (savedAudioPosition != null)
                        model.audioSeekTo(savedAudioPosition!!)
                } else
                    model.releaseMediaPlayer()
            }
        }
    }

    fun onPlayAudioButtonClicked(audioUrl: String) {
        model.playPrayAudio(audioUrl) { success ->
            if (!success)
                view.onFailedAudioPlay()
            else {
                onUpdatingSeekBar()
                view.onSuccessAudioPlay()
            }
        }
    }

    fun onStopAudioButtonClicked(): Boolean {
        return model.stopPrayAudio()
    }

    fun findSelectedQuranReciter(): SoreReciters =
        SoreReciters.entries.find { it.reciterDisplayName == model.getSelectedQuranReciter() }
            ?: SoreReciters.ABDOL_VASET

    fun findSelectedPrayReciter(): PrayReciters =
        PrayReciters.entries.find { it.reciterDisplayName == model.getSelectedPrayReciter() }
            ?: PrayReciters.MOHSEN_FARAHMAND

    fun isMediaPlayerPrepared(): Boolean = model.isMediaPlayerAlreadyPrepared()

    fun isFirstTimePlaying(): Boolean = model.isFirstTimePlaying()

    fun seekTo(position: Int) {
        model.audioSeekTo(position)
    }

    private fun onUpdatingSeekBar() {
        val max = model.getAudioMaxDuration()
        updateSeekRunnable = Runnable {
            val current = model.getAudioCurrentPosition()
            view.seekBarUpdater(current, max)
            handler.postDelayed(updateSeekRunnable, 400)
        }
        handler.post(updateSeekRunnable)
        view.setAudioDuration(max)
    }

    private fun providePrayText(prayFilePath: String, prayPersianTranslationFilePath: String) {
        scope.launch {
            try {
                val context = utils.takeContext()
                val arabicFileContent = model.readPrayTextFileFromAsset(context, prayFilePath)
                val persianFileContent = model.readPrayPersianTranslationFileFromAsset(
                    context,
                    prayPersianTranslationFilePath
                )
                view.setupRecyclerViewData(
                    arabicFileContent,
                    persianFileContent,
                    model.getPersianFontSize(),
                    model.getArabicFontSize(),
                    model.getIsBoldText(),
                    model.getFontResId()
                )
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("EXCEPTION", "failed to load file")
            }
        }
    }

    override fun presenterOnDestroy() {
        if (job.isActive)
            job.cancel()
        model.releaseMediaPlayer()
        updateSeekRunnable.let { handler.removeCallbacks(it) }
    }

}