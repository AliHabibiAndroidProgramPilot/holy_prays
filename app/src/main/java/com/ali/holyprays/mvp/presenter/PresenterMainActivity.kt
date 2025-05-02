package com.ali.holyprays.mvp.presenter

import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.model.ModelMainActivity
import com.ali.holyprays.mvp.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity,
) : ActivityLifecycle {

    override fun presenterOnCreate() {
        view.setInsets()
        view.setEachDayPray(model.currentSystemDayOfWeek())
    }

    override fun presenterOnDestroy() {}

}