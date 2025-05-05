package com.ali.holyprays.mvp.view

import android.content.Context
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
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

    private var categoryTextTitle: String =
        utils.takeActivityIntentExtra()!!.getStringExtra("TAG_VALUE")!!

    // Put One Of Enum Instance In category Variable
    private var category: PrayCategories =
        PrayCategories.provideCategoryFromText(utils.takeActivityResources()!!, categoryTextTitle)!!

    fun setInsetsAndUiColors() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val window = utils.takeWindow()
        window!!.statusBarColor = ContextCompat.getColor(context, R.color.actionBar_color)
        window.navigationBarColor = ContextCompat.getColor(context, R.color.main_bg_gradient_end)
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()?.onBackPressed()
        }
    }

    fun setToolbarTopText() {
        binding.txtCategory.text = categoryTextTitle
    }

    fun setupMainRecycler() {
        binding.prayListRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val prayNameList = providePrayNameList()
        binding.prayListRecycler.adapter = PrayListRecyclerAdapter(prayNameList)
    }

    private fun providePrayNameList(): List<PrayDataModel> {
        return category.let {
            PrayRepository.providePrayByCategory(it)
        }
    }

}