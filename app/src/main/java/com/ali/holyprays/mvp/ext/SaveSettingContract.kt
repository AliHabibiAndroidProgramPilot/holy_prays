package com.ali.holyprays.mvp.ext

interface SaveSettingContract {

    fun onSavePersianFontSize(persianFontSize: Float)

    fun onSaveArabicFontSize(arabicFontSize: Float)

    fun onSaveBoldText(isBold: Boolean)

    fun onSaveSelectedFont(fontResId: Int)

}