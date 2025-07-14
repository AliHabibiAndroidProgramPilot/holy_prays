package com.ali.holyprays.mvp.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.holyprays.R
import com.ali.holyprays.adapters.PrayTextRecyclerAdapter
import com.ali.holyprays.databinding.ActivityPrayTextBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.presenter.PresenterPrayTextActivity
import com.ali.holyprays.provider.PrayCategories
import com.ali.holyprays.provider.PrayDataModel
import com.ali.holyprays.provider.Reciter
import com.ali.holyprays.ui.SettingActivity
import java.util.Locale

class ViewPrayTextActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityPrayTextBinding =
        ActivityPrayTextBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    private val intent = utils.takeActivityIntentExtra()

    private var playState = false

    private lateinit var adapter: PrayTextRecyclerAdapter

    @Suppress("DEPRECATION")
    private val pray = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        intent!!.getParcelableExtra("PRAY_EXTRA", PrayDataModel::class.java)
    else
        intent!!.getParcelableExtra("PRAY_EXTRA")

    lateinit var presenterContract: PresenterPrayTextActivity

    val setStatusBarColor = {
        val window = utils.takeWindow()
        val insetsController = WindowCompat.getInsetsController(window!!, window.decorView)
        window.statusBarColor = ContextCompat.getColor(context, R.color.background_black)
        window.navigationBarColor = ContextCompat.getColor(context, R.color.background_black)
        insetsController.isAppearanceLightStatusBars = false
    }

    private val setPrayNameText = {
        binding.txtPrayName.text = pray?.prayName
    }

    fun setInsetsAndUiColor() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setStatusBarColor()
    }

    fun setupRecyclerViewData(
        arabicTextList: List<String>,
        persianTextList: List<String>,
        pFontSize: Float,
        aFontSize: Float,
        isBoldText: Boolean,
        selectedFontResId: Int
    ) {
        setPrayNameText()
        binding.prayTextRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = PrayTextRecyclerAdapter(
            arabicTextList,
            persianTextList,
            pray?.prayCategory,
        )
        adapter.persianFontSize = pFontSize
        adapter.arabicFontSize = aFontSize
        adapter.isBoldText = isBoldText
        adapter.selectedFontResId = selectedFontResId
        binding.prayTextRecycler.adapter = adapter
    }

    fun navigationBackClickHandler() {
        binding.icClose.setOnClickListener {
            utils.takeBackPressedDispatchers()?.onBackPressed()
        }
    }

    fun navigationToSettingActivity() {
        binding.icSetting.setOnClickListener {
            context.startActivity(
                Intent(context, SettingActivity::class.java)
            )
        }
    }

    fun playPrayAudioManager() {
        val uiChanges: (Boolean) -> Unit = { isNeedLoading ->
            binding.icPlay.setImageResource(R.drawable.ic_pause)
            if (!presenterContract.isMediaPlayerPrepared() && isNeedLoading)
                binding.progressIndicator.visibility = View.VISIBLE
        }
        val toastMessage = "نسخه صوتی ${pray?.prayName} فعلا در دسترس نیست"
        binding.icPlay.setOnClickListener {
            playState = !playState
            if (playState) {
                if (pray?.prayCategory == PrayCategories.SORE) {
                    val reciter: Reciter = presenterContract.findSelectedReciter()
                    val prayAudioUrl = reciter.getAudioUrl(pray.prayName)
                    presenterContract.onPlayAudioButtonClicked(prayAudioUrl)
                    uiChanges(true)
                } else {
                    pray?.prayAudioResId?.let {
                        presenterContract.onPlayAudioButtonCLicked(context, it)
                        handleSeekBarVisibility(View.VISIBLE)
                        uiChanges(false)
                    } ?: Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show()
                }
            } else {
                binding.icPlay.setImageResource(R.drawable.ic_play)
                presenterContract.onStopAudioButtonClicked()
            }
        }
    }

    fun seekBarUpdater(current: Int, duration: Int) {
        binding.audioSeekBar.apply {
            max = duration
            progress = current
        }
        val timeText: String = current.toString()
        binding.currentChronometerText.text = timeText.formatToTime(current)
        binding.audioSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(view: SeekBar?, position: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(view: SeekBar?) {
                presenterContract.seekTo(view!!.progress)
            }

        })
    }

    fun setAudioDuration(duration: Int) {
        binding.maxChronometerText.text = duration.toString().formatToTime(duration)
    }

    fun onPauseMediaPlayerForceStop() {
        playState = !playState
        binding.icPlay.setImageResource(R.drawable.ic_play)
        binding.progressIndicator.visibility = View.GONE
    }

    fun invalidateRecycler(
        pFontSize: Float,
        aFontSize: Float,
        isBoldText: Boolean,
        selectedFontResId: Int
    ) {
        if (::adapter.isInitialized) {
            adapter.persianFontSize = pFontSize
            adapter.arabicFontSize = aFontSize
            adapter.isBoldText = isBoldText
            adapter.selectedFontResId = selectedFontResId
            adapter.notifyItemRangeChanged(0, adapter.itemCount)
        } else return
    }

    val onFailedAudioPlay: () -> Unit = {
        binding.progressIndicator.visibility = View.GONE
        handleSeekBarVisibility(View.GONE)
        binding.icPlay.setImageResource(R.drawable.ic_play)
        Toast.makeText(
            context,
            "پخش صوت با مشکل مواجه شد لطفا اتصال اینترنت خود را بررسی کنید",
            Toast.LENGTH_LONG
        ).show()
        handleSeekBarVisibility(View.GONE)
    }

    val onSuccessAudioPlay: () -> Unit = {
        binding.progressIndicator.visibility = View.GONE
        handleSeekBarVisibility(View.VISIBLE)
    }

    /*fun manageRecyclerScroll() {
        binding.prayTextRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 10) {
                    // Scrolling down
                    animateBox(true)
                } else if (dy < -10) {
                    // Scrolling up
                    animateBox(false)
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }*/

    fun provideFilesPath(): String = pray?.prayFilePath!!

    fun providePrayPersianTranslationFilePath(): String = pray?.prayPersianTranslationFilePath!!

    private fun handleSeekBarVisibility(visibility: Int) {
        binding.audioSeekBar.visibility = visibility
        binding.currentChronometerText.visibility = visibility
        binding.maxChronometerText.visibility = visibility
    }

    private fun String.formatToTime(milliseconds: Int): String {
        val seconds: Int = (milliseconds / 1000) % 60
        val minutes: Int = (milliseconds / (1000 * 60)) % 60
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
    }

}