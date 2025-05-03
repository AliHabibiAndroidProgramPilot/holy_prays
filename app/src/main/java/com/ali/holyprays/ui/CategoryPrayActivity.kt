package com.ali.holyprays.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelCategoryPrayActivity
import com.ali.holyprays.mvp.presenter.PresenterCategoryPrayActivity
import com.ali.holyprays.mvp.view.ViewCategoryPrayActivity

class CategoryPrayActivity : AppCompatActivity(), ActivityUtils {

    private lateinit var presente: PresenterCategoryPrayActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val model = ModelCategoryPrayActivity()
        val view = ViewCategoryPrayActivity(this, this)
        presente = PresenterCategoryPrayActivity(view, model)
        presente.presenterOnCreate()
        setContentView(view.binding.root)
    }

    override fun onDestroy() {
        presente.presenterOnDestroy()
        super.onDestroy()
    }

    override fun takeWindow(): Window = this.window

    override fun takeContext(): Context = this

    override fun takeBackPressedDispatchers(): OnBackPressedDispatcher = onBackPressedDispatcher

    override fun takeActivityIntentExtra(): Intent = intent

}