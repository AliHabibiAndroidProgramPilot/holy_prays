package com.ali.holyprays.mvp.view

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.holyprays.adapters.PrayListRecyclerAdapter
import com.ali.holyprays.databinding.ActivityPrayCategoryTestBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.provider.PrayCategories
import com.ali.holyprays.provider.PrayDataModel
import com.ali.holyprays.provider.PrayRepository

class ViewCategoryPrayActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityPrayCategoryTestBinding =
        ActivityPrayCategoryTestBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    // Converts Intent String Extra Value (Buttons Tag) Into Matched Enum Instance
    private var categoryTitle: PrayCategories =
        utils.takeActivityIntentExtra()!!.getStringExtra("EXTRA_CATEGORY")?.let {
            PrayCategories.valueOf(it)
        } ?: error("Category is Missing -> Buttons tag and string intent problem!")

    // Put One Of Enum Instance In category Variable
    private var category: PrayCategories =
        PrayCategories.provideCategoryFromText(categoryTitle.name)!!

    fun setInsetsAndUiColors() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (isDarkModeEnabled()) {
            val window = utils.takeWindow()!!
            val insetsController = WindowCompat.getInsetsController(window, window.decorView)
            insetsController.isAppearanceLightStatusBars = true
            insetsController.isAppearanceLightNavigationBars = true
        }
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()?.onBackPressed()
        }
    }

    fun setToolbarTopText() {
        val resources = utils.takeActivityResources()
        binding.txtCategory.text = resources?.getText(category.stringResId)
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

    private fun isDarkModeEnabled(): Boolean {
        val currentNightMode =
            context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }

}