package com.ali.holyprays.mvp.view

import android.content.Context
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.holyprays.R
import com.ali.holyprays.adapters.PrayListRecyclerAdapter
import com.ali.holyprays.databinding.ActivityCategoryPrayBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.provider.PrayCategories
import com.ali.holyprays.provider.PrayDataModel
import com.ali.holyprays.provider.PrayRepository

class ViewCategoryPrayActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityCategoryPrayBinding =
        ActivityCategoryPrayBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    // Converts Intent String Extra Value (Buttons Tag) Into Matched Enum Instance
    private var categoryTitle: PrayCategories =
        utils.takeActivityIntentExtra()!!.getStringExtra("EXTRA_CATEGORY")?.let {
            PrayCategories.valueOf(it)
        } ?: error("Category is Missing -> Buttons tag and string intent problem!")

    // Put One Of Enum Instance In category Variable
    private var category: PrayCategories =
        PrayCategories.provideCategoryFromText(categoryTitle.name)!!

    val setStatusBarColor = {
        val window = utils.takeWindow()
        val insetsController = WindowCompat.getInsetsController(window!!, window.decorView)
        window.statusBarColor = ContextCompat.getColor(context, R.color.background_black)
        window.navigationBarColor = ContextCompat.getColor(context, R.color.background_black)
        insetsController.isAppearanceLightStatusBars = false
    }

    fun setInsetsAndUiColors() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setStatusBarColor()
    }

    fun navigationBackHandler() {
        binding.icNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()?.onBackPressed()
        }
    }

    fun setToolbarTopText() {
        val resources = utils.takeActivityResources()
        binding.txtPrayName.text = resources?.getText(category.stringResId)
    }

    fun setupMainRecycler() {
        binding.prayListRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val prayNameList = providePrayNameList()
        binding.prayListRecycler.adapter = PrayListRecyclerAdapter(prayNameList, context)
    }

    private fun providePrayNameList(): List<PrayDataModel> {
        return category.let {
            PrayRepository.providePrayByCategory(it)
        }
    }

}