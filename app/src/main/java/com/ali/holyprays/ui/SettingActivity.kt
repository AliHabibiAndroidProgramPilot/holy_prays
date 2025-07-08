package com.ali.holyprays.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelSettingActivity
import com.ali.holyprays.mvp.presenter.PresenterSettingActivity
import com.ali.holyprays.mvp.view.ViewSettingActivity

class SettingActivity : AppCompatActivity(), ActivityUtils {

    private lateinit var presenter: PresenterSettingActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val model = ModelSettingActivity(this)
        val view = ViewSettingActivity(this, this)
        presenter = PresenterSettingActivity(view, model, this)
        view.presenterContract = presenter
        setContentView(view.binding.root)
        presenter.presenterOnCreate()
    }

    override fun onDestroy() {
        presenter.presenterOnDestroy()
        super.onDestroy()
    }

    override fun takeContext() = this

    override fun takeLifecycleOwner(): LifecycleOwner = this

    override fun takeBackPressedDispatchers() = onBackPressedDispatcher

    override fun takeFinishActivity() {
        finish()
    }
}