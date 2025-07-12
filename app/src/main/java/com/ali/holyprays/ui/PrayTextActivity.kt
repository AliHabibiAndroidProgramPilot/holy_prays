package com.ali.holyprays.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelPrayTextActivity
import com.ali.holyprays.mvp.presenter.PresenterPrayTextActivity
import com.ali.holyprays.mvp.view.ViewPrayTextActivity

class PrayTextActivity : AppCompatActivity(), ActivityUtils {

    private lateinit var presenter: PresenterPrayTextActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val model = ModelPrayTextActivity(this)
        val view = ViewPrayTextActivity(this, this)
        presenter = PresenterPrayTextActivity(view, model, this)
        view.presenterContract = presenter
        setContentView(view.binding.root)
        presenter.presenterOnCreate()
    }

    override fun onPause() {
        presenter.presenterOnPause()
        super.onPause()
    }

    override fun onResume() {
        presenter.presenterOnResume()
        super.onResume()
    }

    override fun onDestroy() {
        presenter.presenterOnDestroy()
        super.onDestroy()
    }

    override fun takeContext(): Context = this

    override fun takeWindow(): Window = this.window

    override fun takeBackPressedDispatchers(): OnBackPressedDispatcher = onBackPressedDispatcher

    override fun takeActivityIntentExtra(): Intent = intent
}