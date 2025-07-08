package com.ali.holyprays.mvp.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.holyprays.R
import com.ali.holyprays.adapters.PrayTextRecyclerAdapter
import com.ali.holyprays.databinding.ActivityPrayTextBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.provider.PrayDataModel
import com.ali.holyprays.ui.SettingActivity

class ViewPrayTextActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityPrayTextBinding =
        ActivityPrayTextBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    private val intent = utils.takeActivityIntentExtra()

    private lateinit var adapter: PrayTextRecyclerAdapter

    @Suppress("DEPRECATION")
    private val pray = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        intent!!.getParcelableExtra("PRAY_EXTRA", PrayDataModel::class.java)
    else
        intent!!.getParcelableExtra("PRAY_EXTRA")

    val setStatusBarColor = {
        val window = utils.takeWindow()
        val insetsController = WindowCompat.getInsetsController(window!!, window.decorView)
        window.statusBarColor = ContextCompat.getColor(context, R.color.background_black)
        window.navigationBarColor = ContextCompat.getColor(context, R.color.background_black)
        insetsController.isAppearanceLightStatusBars = false
    }

    private val setPrayNameText = {
        binding.txtPrayName.text = pray?.prayName
    }

    fun setInsetsAndUiColor() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setStatusBarColor()
    }

    fun setupRecyclerViewData(
        arabicTextList: List<String>,
        persianTextList: List<String>,
        pFontSize: Float,
        aFontSize: Float,
        isBoldText: Boolean,
        selectedFontResId: Int
    ) {
        setPrayNameText()
        binding.prayTextRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = PrayTextRecyclerAdapter(
            arabicTextList,
            persianTextList,
            pray?.prayCategory,
        )
        adapter.persianFontSize = pFontSize
        adapter.arabicFontSize = aFontSize
        adapter.isBoldText = isBoldText
        adapter.selectedFontResId = selectedFontResId
        binding.prayTextRecycler.adapter = adapter
    }

    fun navigationBackClickHandler() {
        binding.icClose.setOnClickListener {
            utils.takeBackPressedDispatchers()?.onBackPressed()
        }
    }

    fun navigationToSettingActivity() {
        binding.icSetting.setOnClickListener {
            context.startActivity(
                Intent(context, SettingActivity::class.java)
            )
        }
    }

    fun invalidateRecycler(
        pFontSize: Float,
        aFontSize: Float,
        isBoldText: Boolean,
        selectedFontResId: Int
    ) {
        if (::adapter.isInitialized) {
            adapter.persianFontSize = pFontSize
            adapter.arabicFontSize = aFontSize
            adapter.isBoldText = isBoldText
            adapter.selectedFontResId = selectedFontResId
            adapter.notifyItemRangeChanged(0, adapter.itemCount)
        } else return
    }

    /*fun manageRecyclerScroll() {
        binding.prayTextRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 10) {
                    // Scrolling down
                    animateBox(true)
                } else if (dy < -10) {
                    // Scrolling up
                    animateBox(false)
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }*/

    fun provideFilesPath(): String = pray?.prayFilePath!!

    fun providePrayPersianTranslationFilePath(): String = pray?.prayPersianTranslationFilePath!!

}