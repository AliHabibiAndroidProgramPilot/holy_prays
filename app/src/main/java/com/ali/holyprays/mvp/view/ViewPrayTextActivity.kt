package com.ali.holyprays.mvp.view

import android.content.Context
import android.graphics.PorterDuff
import android.os.Build
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
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
//        val window = utils.takeWindow()
//        window!!.statusBarColor = ContextCompat.getColor(context, R.color.actionBar_color)
//        window.navigationBarColor = ContextCompat.getColor(context, R.color.main_bg_gradient_end)
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()!!.onBackPressed()
        }
    }

    fun setToolbarText() {
        binding.txtPrayName.text = pray?.prayName
    }

    fun setupRecyclerViewData(arabicTextList: List<String>, persianTextList: List<String>) {
        binding.prayTextRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = PrayTextRecyclerAdapter(arabicTextList, persianTextList, pray?.prayCategory)
        binding.prayTextRecycler.adapter = adapter
    }

    fun manageRecyclerScroll() {
        binding.prayTextRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 10) {
                    // Scrolling down
                    animateBoxAndToolbar(true)
                } else if (dy < -10) {
                    // Scrolling up
                    animateBoxAndToolbar(false)
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    fun textModifierBoxButtonsClickHandler() {
        val buttonPersianTranslation = binding.icEnablePersianTranslation
        var isPersianTranslationEnabled = true
        val buttonDarkMode = binding.icDarkMode
        var isDarkModeEnabled = false
        buttonDarkMode.setOnClickListener {
            if (!isDarkModeEnabled) {
                buttonDarkMode.setColorFilter(
                    ContextCompat.getColor(context, R.color.new_dark_green),
                    PorterDuff.Mode.SRC_IN
                )
                darkAndLightThemeChanger(false)
                isDarkModeEnabled = true
            } else {
                buttonDarkMode.setColorFilter(
                    ContextCompat.getColor(context, R.color.inactivate_color),
                    PorterDuff.Mode.SRC_IN
                )
                darkAndLightThemeChanger(true)
                isDarkModeEnabled = false
            }
        }
        buttonPersianTranslation.setOnClickListener {
            if (isPersianTranslationEnabled) {
                buttonPersianTranslation.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_translation_control_color
                    )
                )
                isPersianTranslationEnabled = false
                adapter.isPersianTranslationVisible = false
            } else {
                buttonPersianTranslation.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_translation_green_color
                    )
                )
                isPersianTranslationEnabled = true
                adapter.isPersianTranslationVisible = true
            }

        }
    }

    fun provideFilesPath(): String = pray?.prayFilePath!!

    fun providePrayPersianTranslationFilePath(): String = pray?.prayPersianTranslationFilePath!!

    private fun animateBoxAndToolbar(isShowing: Boolean) {
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
    }

    private fun darkAndLightThemeChanger(isLight: Boolean) {
        if (isLight) {
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
                ContextCompat.getColor(
                    context,
                    R.color.black
                )
            )
            adapter.isLightModeOn = true
        } else {
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
                ContextCompat.getColor(
                    context,
                    R.color.white
                )
            )
            adapter.isLightModeOn = false
        }
    }

}