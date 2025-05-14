package com.ali.holyprays.provider

import com.ali.holyprays.R

enum class PrayCategories(val stringResId: Int) {

    ZIARAT(R.string.zirat),
    RAMADAN_PRAY(R.string.ramdan_pray),
    SORE(R.string.sore),
    NAMAZ(R.string.namaz),
    NAMAZ_TAGHIBAT(R.string.namaz_taghibat),
    WEEK_ZIARAT(R.string.week_zirat),
    GHADR_NIGHTS(R.string.ghadr_nights),
    PRAYS(R.string.prays);

    companion object {
        fun provideCategoryFromText(category: String): PrayCategories? {
            return entries.find { enumItem ->
                enumItem.name == category
            }
        }
    }
}