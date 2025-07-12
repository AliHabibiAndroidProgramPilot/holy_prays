package com.ali.holyprays.mvp.model

import android.content.Context
import com.ali.holyprays.R
import com.ali.holyprays.provider.Reciter

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
                edit().putString("SELECTED_RECITER", Reciter.ABDOL_VASET.reciterDisplayName).apply()
        }
    }

//    fun currentSystemDayOfWeek(): Int = LocalDate.now().dayOfWeek.value

}