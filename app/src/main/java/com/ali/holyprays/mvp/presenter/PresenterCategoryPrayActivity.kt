package com.ali.holyprays.mvp.presenter

import com.ali.holyprays.mvp.ext.ActivityLifecycle
import com.ali.holyprays.mvp.model.ModelCategoryPrayActivity
import com.ali.holyprays.mvp.view.ViewCategoryPrayActivity

class PresenterCategoryPrayActivity(
    private val view: ViewCategoryPrayActivity,
    private val model: ModelCategoryPrayActivity
) : ActivityLifecycle {

    override fun presenterOnCreate() {
        view.setInsets()
    }

    override fun presenterOnDestroy() {}

}