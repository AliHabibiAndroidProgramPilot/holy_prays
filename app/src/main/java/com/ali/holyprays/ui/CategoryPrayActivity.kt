package com.ali.holyprays.ui

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
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

    override fun attachBaseContext(newBase: Context?) {
        val config = Configuration(newBase?.resources?.configuration)
        config.fontScale = 1.2f
        val context = newBase?.createConfigurationContext(config)
        super.attachBaseContext(context)
    }

    override fun onDestroy() {
        presente.presenterOnDestroy()
        super.onDestroy()
    }

    override fun takeWindow(): Window = this.window

    override fun takeContext(): Context = this

    override fun takeBackPressedDispatchers(): OnBackPressedDispatcher = onBackPressedDispatcher

    override fun takeActivityIntentExtra(): Intent = intent

    override fun takeActivityResources(): Resources = resources

}