package com.ali.holyprays.mvp.view

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.holyprays.databinding.ActivityCategoryPrayBinding
import com.ali.holyprays.mvp.ext.ActivityUtils

class ViewCategoryPrayActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityCategoryPrayBinding =
        ActivityCategoryPrayBinding.inflate(LayoutInflater.from(context))

    fun setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val window = utils.takeWindow()
        window!!.statusBarColor = Color.rgb(221, 229, 182)
        window.navigationBarColor = Color.rgb(240, 234, 210)
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()?.onBackPressed()
        }
    }

    fun setToolbarTopText() {

    }

}