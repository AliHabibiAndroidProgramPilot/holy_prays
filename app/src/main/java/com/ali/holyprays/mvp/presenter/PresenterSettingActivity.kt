package com.ali.holyprays.mvp.presenter

import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.ext.SaveSettingContract
import com.ali.holyprays.mvp.model.ModelSettingActivity
import com.ali.holyprays.mvp.view.ViewSettingActivity

class PresenterSettingActivity(
    private val view: ViewSettingActivity,
    private val model: ModelSettingActivity,
    private val utils: ActivityUtils
) : ActivityLifecycle, SaveSettingContract {

    override fun presenterOnCreate() {
        view.setUiInsets()
        view.navigationBackHandler()
        view.settingChangesUiHandler()
        view.saveSettingClickHandler()
        view.setSavedSetting(
            model.getPersianFontSize(),
            model.getArabicFontSize(),
            model.getIsBoldText(),
            model.getFontResId(),
            model.getSelectedReciter()
        )
    }

    override fun presenterOnDestroy() {

    }

    override fun onSaveBoldText(isBold: Boolean) {
        model.saveIsTextBolded(isBold)
    }

    override fun onSavePersianFontSize(persianFontSize: Float) {
        model.savePersianFontSize(persianFontSize.toFloat())
    }

    override fun onSaveArabicFontSize(arabicFontSize: Float) {
        model.saveArabicFontSize(arabicFontSize.toFloat())
    }

    override fun onSaveSelectedFont(fontResId: Int) {
        model.saveFontResId(fontResId)
    }

    override fun onSaveSelectedReciter(selectedReciterName: String) {
        model.saveSelectedReciter(selectedReciterName)
    }

}