package com.ali.holyprays.mvp.presenter

import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelMainActivity
import com.ali.holyprays.mvp.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity,
    private val utils: ActivityUtils
) : ActivityLifecycle {

    override fun presenterOnCreate() {
        view.setInsets()
        view.setEachDayPray(model.currentSystemDayOfWeek())
        view.intentToCategoryPrayActivity(utils.takeContext())
    }

    override fun presenterOnDestroy() {}

}