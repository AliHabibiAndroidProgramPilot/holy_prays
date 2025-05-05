package com.ali.holyprays.mvp.view

import android.content.Context
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.holyprays.R
import com.ali.holyprays.databinding.ActivityPrayTextBinding
import com.ali.holyprays.mvp.ext.ActivityUtils

class ViewPrayTextActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityPrayTextBinding = ActivityPrayTextBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    fun setInsetsAndUiColor() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Set Right Color For Status Bar
        val window = utils.takeWindow()
        window!!.statusBarColor = ContextCompat.getColor(context, R.color.actionBar_color)
        window.navigationBarColor = ContextCompat.getColor(context, R.color.main_bg_gradient_end)
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()!!.onBackPressed()
        }
    }

}