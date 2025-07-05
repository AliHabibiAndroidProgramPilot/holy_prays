package com.ali.holyprays.mvp.presenter

import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelSettingActivity
import com.ali.holyprays.mvp.view.ViewSettingActivity

class PresenterSettingActivity(
    private val view: ViewSettingActivity,
    private val model: ModelSettingActivity,
    private val utils: ActivityUtils
) : ActivityLifecycle {
    override fun presenterOnCreate() {
        view.setUiInsets()
        view.setSavedSetting(
            model.getPersianFontSize().toInt(),
            model.getArabicFontSize().toInt(),
            model.getIsBoldText(),
            model.getFontResId()
        )
        view.navigationBackHandler()
        view.settingChangesUiHandler()
    }

    override fun presenterOnDestroy() {

    }
}