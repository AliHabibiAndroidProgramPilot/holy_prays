package com.ali.holyprays.mvp.presenter

import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.ext.SaveSettingContract
import com.ali.holyprays.mvp.model.ModelSettingActivity
import com.ali.holyprays.mvp.view.ViewSettingActivity

class PresenterSettingActivity(
    private val view: ViewSettingActivity,
    private val model: ModelSettingActivity,
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
            model.getSelectedQuranReciter(),
            model.getSelectedPrayReciter()
        )
    }

    override fun presenterOnDestroy() {

    }

    override fun onSaveBoldText(isBold: Boolean) {
        model.saveIsTextBolded(isBold)
    }

    override fun onSavePersianFontSize(persianFontSize: Float) {
        model.savePersianFontSize(persianFontSize)
    }

    override fun onSaveArabicFontSize(arabicFontSize: Float) {
        model.saveArabicFontSize(arabicFontSize)
    }

    override fun onSaveSelectedFont(fontResId: Int) {
        model.saveFontResId(fontResId)
    }

    override fun onSaveSelectedQuranReciter(selectedReciterName: String) {
        model.saveSelectedQuranReciter(selectedReciterName)
    }

    override fun onSaveSelectedPrayReciter(selectedReciterName: String) {
        model.saveSelectedPrayReciter(selectedReciterName)
    }

}