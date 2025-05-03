package com.ali.holyprays.provider

data class PrayDataModel(
    val id: Int,
    val prayName: String,
    val prayDetail: String?,
    val prayFilePath: String?,
    val prayAudioURl: String?
)
