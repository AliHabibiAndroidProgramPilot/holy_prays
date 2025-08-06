package com.ali.holyprays.mvp.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.holyprays.R
import com.ali.holyprays.databinding.ActivityMainBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.provider.PrayCategories
import com.ali.holyprays.ui.CategoryPrayActivity
import com.ali.holyprays.ui.FragmentZekrCounter
import com.ali.holyprays.ui.MemorialFragment
import com.ali.holyprays.ui.SettingActivity

class ViewMainActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityMainBinding =
        ActivityMainBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    private val setStatusBarColor = {
        val window = utils.takeWindow()
        val insetsController = WindowCompat.getInsetsController(window!!, window.decorView)
        insetsController.isAppearanceLightStatusBars = false
        insetsController.isAppearanceLightNavigationBars = false
    }

    fun setInsetsAndUiColor() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setStatusBarColor()
    }

    fun intentToCategoryPrayActivity(packageContext: Context) {
        listOf(
            binding.btnPrays,
            binding.btnRamadan,
            binding.btnZirat,
            binding.btnSore,
            binding.btnTaghibat,
            binding.btnWeekZirat,
            binding.btnNamaz,
            binding.btnGhadrNights
        ).forEach { button ->
            button.setOnClickListener {
                val category: PrayCategories = PrayCategories.valueOf(it.tag.toString().uppercase())
                val intent = Intent(packageContext, CategoryPrayActivity::class.java)
                intent.putExtra("EXTRA_CATEGORY", category.name)
                context.startActivity(intent)
            }
        }
    }

    fun intentToSettingActivity(packageContext: Context) {
        binding.icSetting.setOnClickListener {
            context.startActivity(Intent(packageContext, SettingActivity::class.java))
        }
    }

    fun setFragments(dayOfTheWeek: String, prayOfTheDay: String) {
        val fragmentManager = utils.takeFragmentManager()!!
        binding.icTasbih.setOnClickListener {
            binding.fragmentContainer.visibility = View.VISIBLE
            if (fragmentManager.fragments.isEmpty()) {
                val fragment = FragmentZekrCounter.newInstance(dayOfTheWeek, prayOfTheDay)
                fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out
                    )
                    .replace(R.id.fragment_container, fragment)
                    .commit()
            }
        }
        binding.icMemorial.setOnClickListener {
            binding.fragmentContainer.visibility = View.VISIBLE
            if (fragmentManager.fragments.isEmpty()) {
                val fragment = MemorialFragment()
                fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out
                    )
                    .replace(R.id.fragment_container, fragment)
                    .commit()
            }

        }
    }

}