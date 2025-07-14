package com.ali.holyprays.provider

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class PrayDataModel(
    val id: Int,
    val prayCategory: PrayCategories,
    val prayName: String,
    val prayDetail: String?,
    val prayFilePath: String?,
    val prayPersianTranslationFilePath: String?,
    val prayAudioResId: Int?
) : Parcelable
