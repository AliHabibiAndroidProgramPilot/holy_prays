package com.ali.holyprays.mvp.presenter

import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelPrayTextActivity
import com.ali.holyprays.mvp.view.ViewPrayTextActivity

class PresenterPrayTextActivity(
    private val view: ViewPrayTextActivity,
    private val model: ModelPrayTextActivity,
    private val utils: ActivityUtils
) : ActivityLifecycle {

    override fun presenterOnCreate() {

    }

    override fun presenterOnDestroy() {}

}