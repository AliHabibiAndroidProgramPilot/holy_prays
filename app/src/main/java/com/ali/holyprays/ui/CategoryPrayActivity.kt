package com.ali.holyprays.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.model.ModelCategoryPrayActivity
import com.ali.holyprays.mvp.presenter.PresenterCategoryPrayActivity
import com.ali.holyprays.mvp.view.ViewCategoryPrayActivity

class CategoryPrayActivity : AppCompatActivity() {

    private lateinit var presente: PresenterCategoryPrayActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val model = ModelCategoryPrayActivity()
        val view = ViewCategoryPrayActivity(this)
        setContentView(view.binding.root)
        presente = PresenterCategoryPrayActivity(view, model)
        presente.presenterOnCreate()
    }

    override fun onDestroy() {
        presente.presenterOnDestroy()
        super.onDestroy()
    }
}