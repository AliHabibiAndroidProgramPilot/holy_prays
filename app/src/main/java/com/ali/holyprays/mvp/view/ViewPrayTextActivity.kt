package com.ali.holyprays.mvp.view

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.holyprays.R
import com.ali.holyprays.adapters.PrayTextRecyclerAdapter
import com.ali.holyprays.databinding.ActivityPrayTextBinding
import com.ali.holyprays.databinding.ActivityPrayTextSecondBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.provider.PrayDataModel

class ViewPrayTextActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityPrayTextSecondBinding =
        ActivityPrayTextSecondBinding.inflate(LayoutInflater.from(context))

    private val context = utils.takeContext()

    private val intent = utils.takeActivityIntentExtra()

    @Suppress("DEPRECATION")
    private val pray = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        intent!!.getParcelableExtra("PRAY_EXTRA", PrayDataModel::class.java)
    else
        intent!!.getParcelableExtra("PRAY_EXTRA")

    fun setInsetsAndUiColor() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Set Right Color For Status Bar
//        val window = utils.takeWindow()
//        window!!.statusBarColor = ContextCompat.getColor(context, R.color.actionBar_color)
//        window.navigationBarColor = ContextCompat.getColor(context, R.color.main_bg_gradient_end)
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()!!.onBackPressed()
        }
    }

    fun setToolbarText() {
        binding.txtPrayName.text = pray?.prayName
    }

    fun setupRecyclerViewData(arabicTextList: List<String>, persianTextList: List<String>) {
        binding.prayTextRecycler.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.prayTextRecycler.adapter =
            PrayTextRecyclerAdapter(arabicTextList, persianTextList, pray?.prayCategory)
    }

    fun provideFilesPath(): String = pray?.prayFilePath!!

    fun providePrayPersianTranslationFilePath(): String = pray?.prayPersianTranslationFilePath!!

}