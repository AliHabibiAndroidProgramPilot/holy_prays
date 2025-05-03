package com.ali.holyprays.mvp.view

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    private lateinit var categoryTextTitle: String
    private lateinit var category: PrayCategories

    fun setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val window = utils.takeWindow()
        window!!.statusBarColor = Color.rgb(221, 229, 182)
        window.navigationBarColor = Color.rgb(240, 234, 210)
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()?.onBackPressed()
        }
    }

    fun setToolbarTopText() {
        val intent = utils.takeActivityIntentExtra()
        categoryTextTitle = intent?.getStringExtra("TAG_VALUE") ?: "null intent!"
        category =
            PrayCategories.provideFromTitle(utils.takeActivityResources()!!, categoryTextTitle)!!
        binding.txtCategory.text = categoryTextTitle
    }

    fun setupMainRecycler() {
        binding.prayListRecycler.layoutManager =
            LinearLayoutManager(utils.takeContext(), RecyclerView.VERTICAL, false)
        val prayNameList = providePrayNameList()
        binding.prayListRecycler.adapter = PrayListRecyclerAdapter(prayNameList)
    }

    private fun providePrayNameList(): List<PrayDataModel> {
        return category.let {
            PrayRepository.providePrayByCategory(it)
        }
    }

}