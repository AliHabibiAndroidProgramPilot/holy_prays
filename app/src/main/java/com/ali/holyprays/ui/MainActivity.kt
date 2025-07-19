package com.ali.holyprays.ui

import android.os.Bundle
import android.view.Window
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelMainActivity
import com.ali.holyprays.mvp.presenter.PresenterMainActivity
import com.ali.holyprays.mvp.view.ViewMainActivity

class MainActivity : AppCompatActivity(), ActivityUtils {

    private lateinit var presenter: PresenterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val model = ModelMainActivity(this)
        val view = ViewMainActivity(this, this)
        setContentView(view.binding.root)
        presenter = PresenterMainActivity(view, model, this)
        presenter.presenterOnCreate()
    }

    override fun onDestroy() {
        presenter.presenterOnDestroy()
        super.onDestroy()
    }

    override fun takeWindow(): Window = this.window

    override fun takeFragmentManager(): FragmentManager = supportFragmentManager

    override fun takeContext() = this
}