package com.ali.holyprays.ui

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelSettingActivity
import com.ali.holyprays.mvp.presenter.PresenterSettingActivity
import com.ali.holyprays.mvp.view.ViewSettingActivity

class SettingActivity : AppCompatActivity(), ActivityUtils {

    private lateinit var presenter: PresenterSettingActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val model by lazy { ModelSettingActivity() }
        val view = ViewSettingActivity(this, this)
        setContentView(view.binding.root)
        presenter = PresenterSettingActivity(view, model, this)
        presenter.presenterOnCreate()
    }

    override fun onDestroy() {
        presenter.presenterOnDestroy()
        super.onDestroy()
    }

    override fun takeContext() = this

    override fun takeBackPressedDispatchers() = onBackPressedDispatcher
}