package com.ali.holyprays.provider

import android.content.res.Resources
import com.ali.holyprays.R

enum class PrayCategories(val stringResId: Int) {

    ZIARAT(R.string.zirat),
    RAMADAN_PRAY(R.string.ramdan_pray),
    SORE(R.string.sore),
    NAMAZ(R.string.namaz),
    NAMAZ_TAGHIBAT(R.string.namaz_taghibat),
    WEEK_ZIARAT(R.string.week_zirat),
    PRAYS(R.string.prays);

    companion object {
        fun provideCategoryFromText(resources: Resources, category: String): PrayCategories? {
            return entries.find { enumItem ->
                resources.getString(enumItem.stringResId) == category
            }
        }
    }
}