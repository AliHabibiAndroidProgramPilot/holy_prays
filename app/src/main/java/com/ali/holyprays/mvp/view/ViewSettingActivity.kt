package com.ali.holyprays.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.holyprays.R
import com.ali.holyprays.databinding.ActivitySettingBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.ext.SaveSettingContract

class ViewSettingActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivitySettingBinding =
        ActivitySettingBinding.inflate(LayoutInflater.from(context))

    lateinit var presenterContract: SaveSettingContract

    private val context = utils.takeContext()

    private val fontNames = arrayOf("نبی", "ارغوان", "ارسلان وصام", "آثم", "قلم", "شبنم")

    private val fontResId = arrayOf(
        R.font.nabi,
        R.font.arghavan,
        R.font.arsalan_wessam,
        R.font.authman,
        R.font.qalam,
        R.font.shabnam
    )

    private var persianFontSize: Float? = 16f
    private var arabicFontSize: Float? = 16f
    private var isTextBolded: Boolean = false
    private var selectedFontResId: Int? = R.font.nabi

    val setSavedSetting: (Float, Float, Boolean, Int) -> Unit =
        { pFontSize, aFontSize, boldedText, selectedFont ->
            persianFontSize = pFontSize
            arabicFontSize = aFontSize
            isTextBolded = boldedText
            selectedFontResId = selectedFont
            binding.txtProgressPreviewPersian.text = persianFontSize.toString()
            binding.persianFontSizeSeekBar.progress = persianFontSize!!.toInt()
            binding.txtProgressPreviewArabic.text = arabicFontSize.toString()
            binding.arabicFontSizeSeekBar.progress = arabicFontSize!!.toInt()
            if (isTextBolded) {
                binding.boldTextSwitch.isChecked = true
                binding.boldTextSwitch.thumbIconDrawable =
                    ContextCompat.getDrawable(context, R.drawable.ic_check)
            } else {
                binding.boldTextSwitch.isChecked = false
                binding.boldTextSwitch.thumbIconDrawable =
                    ContextCompat.getDrawable(context, R.drawable.ic_close)
            }
            binding.txtArabicPreview.paint.isFakeBoldText = isTextBolded
            binding.dropdownSelection.setSelection(fontResId.indexOf(selectedFontResId))
            // Set Preview Text Attributes
            binding.txtPersianPreview.textSize = persianFontSize!!
            binding.txtArabicPreview.textSize = arabicFontSize!!
            binding.txtArabicPreview.typeface =
                ResourcesCompat.getFont(context, selectedFontResId!!)
        }

    fun setUiInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            utils.takeBackPressedDispatchers()?.onBackPressed()
        }
    }

    fun settingChangesUiHandler() {
        binding.persianFontSizeSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(view: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    binding.txtProgressPreviewPersian.text = progress.toString()
                    binding.txtPersianPreview.textSize = progress.toFloat()
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(view: SeekBar?) {
                persianFontSize = view?.progress?.toFloat()
            }

        })
        binding.arabicFontSizeSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(view: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    binding.txtProgressPreviewArabic.text = progress.toString()
                    binding.txtArabicPreview.textSize = progress.toFloat()
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(view: SeekBar?) {
                arabicFontSize = view?.progress?.toFloat()
            }

        })
        binding.boldTextSwitch.setOnCheckedChangeListener { switchView, _ ->
            if (switchView.isChecked) {
                binding.txtArabicPreview.paint.isFakeBoldText = true
                // Force Text View To Re Draw Itself
                binding.txtArabicPreview.invalidate()
                binding.boldTextSwitch.thumbIconDrawable =
                    ContextCompat.getDrawable(context, R.drawable.ic_check)
                isTextBolded = true
            } else {
                binding.txtArabicPreview.paint.isFakeBoldText = false
                // Force Text View To Re Draw Itself
                binding.txtArabicPreview.invalidate()
                binding.boldTextSwitch.thumbIconDrawable =
                    ContextCompat.getDrawable(context, R.drawable.ic_close)
                isTextBolded = false
            }

        }
        binding.dropdownSelection.adapter = ArrayAdapter(
            context,
            R.layout.spinner_item,
            fontNames
        ).also {
            it.setDropDownViewResource(R.layout.spinner_item)
        }
        binding.dropdownSelection.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val fontResId = fontResId[position]
                    fontResId.let {
                        binding.txtArabicPreview.typeface = ResourcesCompat.getFont(context, it)
                    }
                    selectedFontResId = fontResId
                }

                override fun onNothingSelected(view: AdapterView<*>?) {

                }

            }
    }

    fun saveSettingClickHandler() {
        binding.btnSaveNewSettings.setOnClickListener {
            presenterContract.onSaveBoldText(isTextBolded)
            presenterContract.onSavePersianFontSize(persianFontSize!!)
            presenterContract.onSaveArabicFontSize(arabicFontSize!!)
            presenterContract.onSaveSelectedFont(selectedFontResId!!)
            utils.takeFinishActivity()
        }
    }
}