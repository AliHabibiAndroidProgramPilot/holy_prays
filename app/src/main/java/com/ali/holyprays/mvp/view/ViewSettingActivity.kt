package com.ali.holyprays.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.holyprays.R
import com.ali.holyprays.databinding.ActivitySettingBinding
import com.ali.holyprays.mvp.ext.ActivityUtils
import com.ali.holyprays.mvp.ext.SaveSettingContract
import com.ali.holyprays.provider.Reciter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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

    private val reciters = arrayOf("عبدالباسط", "شهریار پرهیزکاری", "ماهر المعیقلی", "میثم تمار")

    private var persianFontSize: Float = 16f

    private var arabicFontSize: Float = 16f

    private var isTextBolded: Boolean = false

    private var selectedFontResId: Int = R.font.nabi

    private var selectedReciter: String = "عبدالباسط"

    private var originalPersianFontSize: Float? = null

    private var originalArabicFontSize: Float? = null

    private var originalIsTextBolded: Boolean = false

    private var originalFontResId: Int? = null

    private var originalSelectedReciter: String? = null

    val setSavedSetting: (Float, Float, Boolean, Int, String) -> Unit =
        { pFontSize, aFontSize, boldedText, selectedFont, reciter ->
            persianFontSize = pFontSize
            arabicFontSize = aFontSize
            isTextBolded = boldedText
            selectedFontResId = selectedFont
            selectedReciter = reciter
            originalPersianFontSize = pFontSize
            originalArabicFontSize = aFontSize
            originalIsTextBolded = boldedText
            originalFontResId = selectedFont
            originalSelectedReciter = reciter
            binding.txtProgressPreviewPersian.text = persianFontSize.toString()
            binding.persianFontSizeSeekBar.progress = persianFontSize.toInt()
            binding.txtProgressPreviewArabic.text = arabicFontSize.toString()
            binding.arabicFontSizeSeekBar.progress = arabicFontSize.toInt()
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
            binding.dropdownReciterSelection.setSelection(reciters.indexOf(reciter))
            setReciterProfile(reciters.indexOf(reciter))
            // Set Preview Text Attributes
            binding.txtPersianPreview.textSize = persianFontSize
            binding.txtArabicPreview.textSize = arabicFontSize
            binding.txtArabicPreview.typeface =
                ResourcesCompat.getFont(context, selectedFontResId)
        }

    fun setUiInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setStatusBarColor()
    }

    fun navigationBackHandler() {
        binding.icToolbarNavigationBack.setOnClickListener {
            if (hasUnsavedChanges()) {
                showAlertDialog()
            } else
                utils.takeBackPressedDispatchers()?.onBackPressed()
        }
        utils.takeBackPressedDispatchers()?.addCallback(utils.takeLifecycleOwner()!!) {
            if (hasUnsavedChanges())
                showAlertDialog()
            else {
                isEnabled = false
                utils.takeFinishActivity()
            }
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
                persianFontSize = view?.progress!!.toFloat()
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
                arabicFontSize = view?.progress!!.toFloat()
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
        binding.dropdownReciterSelection.adapter = ArrayAdapter(
            context,
            R.layout.spinner_item,
            reciters
        ).also {
            it.setDropDownViewResource(R.layout.spinner_item)
        }
        binding.dropdownReciterSelection.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedReciter =
                        Reciter.entries.find { it.reciterDisplayName == reciters[position] }?.reciterDisplayName
                            ?: Reciter.ABDOL_VASET.reciterDisplayName
                    setReciterProfile(position)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
    }

    fun saveSettingClickHandler() {
        binding.btnSaveNewSettings.setOnClickListener {
            saveSettingChanges()
        }
    }

    private fun showAlertDialog() {
        val alertDialog by lazy {
            MaterialAlertDialogBuilder(context, R.style.Material_Dialog_Alert)
                .setTitle("خروج بدون ذخیره؟")
                .setMessage("شما تغییراتی ایجاد کرده‌اید. آیا مطمئن هستید که بدون ذخیره خارج می‌شوید؟")
                .setPositiveButton("خروج") { dialog, _ ->
                    dialog.dismiss()
                    utils.takeFinishActivity()
                }
                .setNegativeButton("خیر", null)
                .setNeutralButton("ذخیره تغییرات") { dialog, _ ->
                    saveSettingChanges()
                    dialog.dismiss()
                    utils.takeFinishActivity()
                }
                .create()
        }
        val customFont = ResourcesCompat.getFont(context, R.font.iran_sans_regular)
        with(alertDialog) {
            window?.decorView?.apply {
                setBackgroundResource(R.color.background_black)
                layoutDirection = View.LAYOUT_DIRECTION_RTL
                elevation = 25.0f
                textDirection = View.LAYOUT_DIRECTION_RTL
                setOnShowListener {
                    listOfNotNull(
                        getButton(AlertDialog.BUTTON_POSITIVE),
                        getButton(AlertDialog.BUTTON_NEUTRAL),
                        getButton(AlertDialog.BUTTON_NEGATIVE)
                    ).forEach {
                        it.setTextColor(context.resources.getColor(R.color.golden, null))
                        it.textSize = 16f
                        it.typeface = customFont
                    }
                    /*getButton(AlertDialog.BUTTON_POSITIVE).apply {
                        setTextColor(context.resources.getColor(R.color.golden, null))
                        textSize = 16f
                        typeface = customFont
                    }
                    getButton(AlertDialog.BUTTON_NEUTRAL).apply {
                        setTextColor(context.resources.getColor(R.color.golden, null))
                        textSize = 16f
                        typeface = customFont
                    }
                    getButton(AlertDialog.BUTTON_NEGATIVE).apply {
                        setTextColor(context.resources.getColor(R.color.golden, null))
                        textSize = 16f
                        typeface = customFont
                    }*/
                }
            }
            show()
        }
    }

    private fun setReciterProfile(position: Int) {
        val reciterProfile = binding.reciterProfile
        when (position) {
            0 -> reciterProfile.setImageResource(R.drawable.abdolbesat_singer)
            1 -> reciterProfile.setImageResource(R.drawable.shahriar_prahizkar)
            2 -> reciterProfile.setImageResource(R.drawable.maher)
            3 -> reciterProfile.setImageResource(R.drawable.meysam_tamar)
            else -> reciterProfile.setImageResource(R.drawable.abdolbesat_singer)
        }
    }

    private val hasUnsavedChanges: () -> Boolean = {
        (originalPersianFontSize != persianFontSize ||
                originalArabicFontSize != arabicFontSize ||
                originalIsTextBolded != isTextBolded ||
                originalFontResId != selectedFontResId ||
                originalSelectedReciter != selectedReciter
                )
    }

    private val saveSettingChanges: () -> Unit = {
        presenterContract.onSaveBoldText(isTextBolded)
        presenterContract.onSavePersianFontSize(persianFontSize)
        presenterContract.onSaveArabicFontSize(arabicFontSize)
        presenterContract.onSaveSelectedFont(selectedFontResId)
        presenterContract.onSaveSelectedReciter(selectedReciter)
        utils.takeFinishActivity()
    }

    private val setStatusBarColor = {
        val window = utils.takeWindow()
        val insetsController = WindowCompat.getInsetsController(window!!, window.decorView)
        insetsController.isAppearanceLightStatusBars = false
    }

}