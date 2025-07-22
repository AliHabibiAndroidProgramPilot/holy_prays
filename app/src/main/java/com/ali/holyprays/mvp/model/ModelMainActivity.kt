package com.ali.holyprays.mvp.model

import android.content.Context
import com.ali.holyprays.R
import com.ali.holyprays.provider.SoreReciters
import java.time.LocalDate

class ModelMainActivity(context: Context) {

    init {
        context.getSharedPreferences("SETTING_PREFERENCES", Context.MODE_PRIVATE).apply {
            if (!contains("PERSIAN_FONT_SIZE"))
                edit().putFloat("PERSIAN_FONT_SIZE", 16f).apply()
            if (!contains("ARABIC_FONT_SIZE"))
                edit().putFloat("ARABIC_FONT_SIZE", 16f).apply()
            if (!contains("IS_BOLD_TEXT"))
                edit().putBoolean("IS_BOLD_TEXT", false).apply()
            if (!contains("TEXT_FONT_RES_ID"))
                edit().putInt("TEXT_FONT_RES_ID", R.font.nabi).apply()
            if (!contains("SELECTED_RECITER"))
                edit().putString("SELECTED_RECITER", SoreReciters.ABDOL_VASET.reciterDisplayName).apply()
        }
    }

    private val dayOfTheWeek = currentSystemDayOfWeek()

    fun getDayOfTheWeek(): String {
        return when (dayOfTheWeek) {
            1 -> "ذکر روز دوشنبه"
            2 -> "ذکر روز سه شنبه"
            3 -> "ذکر روز چهار شنبه"
            4 -> "ذکر روز پنج شنبه"
            5 -> "ذکر روز جمعه"
            6 -> "ذکر روز شنبه"
            7 -> "ذکر روز یک شنبه"
            else -> ""
        }
    }

    fun getEachDayPray(): String {
        return when(dayOfTheWeek) {
            1 -> "یا قاضیَ الحاجات"
            2 -> "یا أَرْحَمَ الرَّاحِمِین"
            3 -> "یا حَیُّ یا قَیّومُ"
            4 -> "لا إِلهَ إِلَّا اللَّهُ المَلِک الحقّ المُبین"
            5 -> "الّلهُمَّ صَلِّ عَلَی مُحَمَّدٍ وَآلِ مُحَمَّد"
            6 -> "یا رَبِّ الْعالَمِین"
            7 -> "یا ذَالجَلالِ وَ اْلاِکْرام"
            else -> ""
        }

    }

    private fun currentSystemDayOfWeek(): Int = LocalDate.now().dayOfWeek.value

}