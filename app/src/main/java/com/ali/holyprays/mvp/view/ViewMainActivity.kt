package com.ali.holyprays.mvp.view

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.holyprays.R
import com.ali.holyprays.databinding.ActivityMainSecondBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.provider.PrayCategories
import com.ali.holyprays.ui.CategoryPrayActivity

class ViewMainActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityMainSecondBinding =
        ActivityMainSecondBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    fun setInsetsAndUiColor() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (isDarkModeEnabled()) {
            val window = utils.takeWindow()!!
            val insetsController = WindowCompat.getInsetsController(window, window.decorView)
            insetsController.isAppearanceLightStatusBars = true
            insetsController.isAppearanceLightNavigationBars = true
        }
    }

    fun setEachDayPray(dayOfWeekValue: Int) {
        val dayOfTheWeekText = binding.txtDayOfWeek
        val dayPrayText = binding.txtDayPray
        when (dayOfWeekValue) {
            1 -> {
                dayOfTheWeekText.setText(R.string.day_monday) // Monday
                dayPrayText.setText(R.string.monday_pray)
            }

            2 -> {
                dayOfTheWeekText.setText(R.string.day_tuesday) // Tuesday
                dayPrayText.setText(R.string.tuesday_pray)
            }

            3 -> {
                dayOfTheWeekText.setText(R.string.day_wednesday) // Wednesday
                dayPrayText.setText(R.string.wednesday_pray)
            }

            4 -> {
                dayOfTheWeekText.setText(R.string.day_thursday) // Thursday
                dayPrayText.setText(R.string.thursday_pray)
            }

            5 -> {
                dayOfTheWeekText.setText(R.string.day_friday) // Friday
                dayPrayText.setText(R.string.friday_pray)
            }

            6 -> {
                dayOfTheWeekText.setText(R.string.day_saturday) // Saturday
                dayPrayText.setText(R.string.saturday_pray)
            }

            7 -> {
                dayOfTheWeekText.setText(R.string.day_sunday) // Sunday
                dayPrayText.setText(R.string.sunday_pray)
            }
        }
    }

    fun intentToCategoryPrayActivity(packageContext: Context) {
        listOf(
            binding.btnPrays,
            binding.btnRamadan,
            binding.btnZirat,
            binding.btnSore,
            binding.btnTaghibat,
            binding.btnWeekZirat,
            binding.btnNamaz,
            binding.btnGhadrNights
        ).forEach { button ->
            button.setOnClickListener {
                val category: PrayCategories = PrayCategories.valueOf(it.tag.toString().uppercase())
                val intent = Intent(packageContext, CategoryPrayActivity::class.java)
                intent.putExtra("EXTRA_CATEGORY", category.name)
                context.startActivity(intent)
            }
        }
    }

    private fun isDarkModeEnabled(): Boolean {
        val currentNightMode =
            context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }

}