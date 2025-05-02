package com.ali.holyprays.mvp.view

import android.content.Context
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.holyprays.R
import com.ali.holyprays.databinding.ActivityMainBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import java.time.LocalDate

class ViewMainActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun setEachDayPray() {
        val dayOfTheWeekText = binding.txtDayOfWeek
        val dayPrayText = binding.txtDayPray
        val currentDayOfTheWeek = LocalDate.now().dayOfWeek.value
        when (currentDayOfTheWeek) {
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

}