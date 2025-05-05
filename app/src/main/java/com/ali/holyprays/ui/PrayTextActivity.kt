package com.ali.holyprays.ui

import android.content.Context
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
        val model = ModelPrayTextActivity()
        val view = ViewPrayTextActivity(this, this)
        setContentView(view.binding.root)
        presenter = PresenterPrayTextActivity(view, model, this)
        presenter.presenterOnCreate()
    }

    override fun onDestroy() {
        presenter.presenterOnDestroy()
        super.onDestroy()
    }

    override fun takeContext(): Context = this

    override fun takeWindow(): Window = this.window

    override fun takeBackPressedDispatchers(): OnBackPressedDispatcher = onBackPressedDispatcher
}