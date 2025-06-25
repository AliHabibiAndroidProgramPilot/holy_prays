package com.ali.holyprays.mvp.view

import android.content.Context
import android.content.res.Configuration
import android.graphics.PorterDuff
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.holyprays.R
import com.ali.holyprays.adapters.PrayTextRecyclerAdapter
import com.ali.holyprays.databinding.ActivityPrayTextSecondBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.provider.PrayDataModel

class ViewPrayTextActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityPrayTextSecondBinding =
        ActivityPrayTextSecondBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    private val intent = utils.takeActivityIntentExtra()

    private lateinit var adapter: PrayTextRecyclerAdapter

    private val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager =
            context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    @Suppress("DEPRECATION")
    private val pray = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        intent!!.getParcelableExtra("PRAY_EXTRA", PrayDataModel::class.java)
    else
        intent!!.getParcelableExtra("PRAY_EXTRA")

    fun setInsetsAndUiColor() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (isDeviceDarkModeEnabled()) {
            val window = utils.takeWindow()!!
            val insetsController = WindowCompat.getInsetsController(window, window.decorView)
            insetsController.isAppearanceLightStatusBars = true
            insetsController.isAppearanceLightNavigationBars = true
        }
    }


    fun setupRecyclerViewData(arabicTextList: List<String>, persianTextList: List<String>) {
        binding.prayTextRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = PrayTextRecyclerAdapter(arabicTextList, persianTextList, pray?.prayCategory)
        binding.prayTextRecycler.adapter = adapter
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

    /*fun initPersianTranslationButton() {
        var isPersianTranslationEnabled = true
        binding.icEnablePersianTranslation.setOnClickListener {
            isPersianTranslationEnabled =
                persianTranslationButtonUiStateChanger(isPersianTranslationEnabled)
            adapter.isPersianTranslationVisible = isPersianTranslationEnabled
        }
    }*/

    fun initDarkModeButton(listener: () -> Unit) {
        /*var isDarkModeEnabled = false
        binding.icDarkMode.setOnClickListener {
            isDarkModeEnabled = darkModeButtonUiStateChanger(!isDarkModeEnabled)
            adapter.isDarkModeOn = !isDarkModeEnabled
        }*/
//        binding.icDarkMode.setOnClickListener { listener() }
    }

    /*fun initPlusAndMinusTextSizeButtons() {
        binding.icAddTextSize.setOnClickListener {
            doVibrate()
            adapter.textSize += 2f
        }
        binding.icMinusTextSize.setOnClickListener {
            doVibrate()
            adapter.textSize -= 2f
        }
    }*/

    fun provideFilesPath(): String = pray?.prayFilePath!!

    fun providePrayPersianTranslationFilePath(): String = pray?.prayPersianTranslationFilePath!!

    /*private fun animateBox(isShowing: Boolean) {
        if (isShowing) {
            binding.textModifierBox.animate()
                .translationY(binding.textModifierBox.height.toFloat())
                .alpha(0f)
                .setDuration(200)
                .start()
        } else {
            binding.textModifierBox.animate()
                .translationY(0f)
                .alpha(1f)
                .setDuration(200)
                .start()
        }
    }*/

    /*fun darkModeButtonUiStateChanger(isDarkModeEnabled: Boolean) {
        if (isDarkModeEnabled) {
            binding.root.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.background_black
                )
            )
            binding.toolbar.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.background_black
                )
            )
            binding.textModifierBox.setBackgroundResource(R.drawable.text_modifier_box_bg_dark)
            binding.txtPrayName.setTextColor(ContextCompat.getColor(context, R.color.white))
            binding.icToolbarNavigationBack.setColorFilter(
                ContextCompat.getColor(context, R.color.white),
                PorterDuff.Mode.SRC_IN
            )
            binding.icDarkMode.setColorFilter(
                ContextCompat.getColor(context, R.color.new_dark_green),
                PorterDuff.Mode.SRC_IN
            )
            adapter.isDarkModeOn = false
        } else {
            binding.root.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.background_white
                )
            )
            binding.toolbar.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.background_white
                )
            )
            binding.textModifierBox.setBackgroundResource(R.drawable.text_modifier_box_bg_light)
            binding.txtPrayName.setTextColor(ContextCompat.getColor(context, R.color.black))
            binding.icToolbarNavigationBack.setColorFilter(
                ContextCompat.getColor(context, R.color.black),
                PorterDuff.Mode.SRC_IN
            )
            binding.icDarkMode.setColorFilter(
                ContextCompat.getColor(context, R.color.inactivate_color),
                PorterDuff.Mode.SRC_IN
            )
            adapter.isDarkModeOn = true
        }
    }*/

    /*private fun persianTranslationButtonUiStateChanger(isPersianTranslationEnabled: Boolean): Boolean {
        if (isPersianTranslationEnabled) {
            binding.icEnablePersianTranslation.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_translation_control_color
                )
            )
            return false
        } else {
            binding.icEnablePersianTranslation.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_translation_green_color
                )
            )
            return true
        }
    }*/

    private fun textSizeUiStateChanger(textSize: Float) {
        adapter.textSize = textSize.coerceIn(8f, 38f)
    }

    private fun doVibrate() {
        if (vibrator.hasVibrator()) {
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        100,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            else
                vibrator.vibrate(100)
        }
    }

    private fun isDeviceDarkModeEnabled(): Boolean {
        val currentNightMode =
            context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }

}