package com.ali.holyprays.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.ali.holyprays.R
import com.ali.holyprays.databinding.FragmentZekrCounterBinding
import com.ali.holyprays.mvp.ext.FragmentZekrCounterContract
import com.ali.holyprays.mvp.presenter.PresenterZekrCounterFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FragmentZekrCounter : Fragment(), FragmentZekrCounterContract.View {

    private lateinit var binding: FragmentZekrCounterBinding

    private lateinit var presenter: FragmentZekrCounterContract.Presenter

    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        presenter = PresenterZekrCounterFragment()
        binding = FragmentZekrCounterBinding.inflate(layoutInflater)
        presenter.onAttach(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeViewTexts()
        count()
        reset()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initializeViewTexts() {
        binding.txtDayOfWeek.text = arguments?.getString("DAY_OF_THE_WEEK")
        binding.txtDayPray.text = arguments?.getString("PRAY_OF_THE_WEEK")
    }

    override fun count() {
        binding.icAdd.setOnClickListener {
            binding.txtCounterNumber.text = (++count).toString()
            vibration()
        }
    }

    override fun reset() {
        binding.icReset.setOnClickListener {
            if (count > 5) {
                showAlertDialog()
            } else {
                count = 0
                binding.txtCounterNumber.text = count.toString()
            }
        }
    }

    @Suppress("DEPRECATION")
    override fun vibration() {
        val vibrator =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager =
                    requireContext().getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            }
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(90, VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                vibrator.vibrate(90)
            }
        }
    }

    override fun showAlertDialog() {
        val alertDialog by lazy {
            MaterialAlertDialogBuilder(requireContext(), R.style.Material_Dialog_Alert)
                .setTitle("بازنشانی؟")
                .setMessage("آیا از بازنشانی ذکر شمار اطمینان دارید؟")
                .setPositiveButton("بله") { dialog, _ ->
                    count = 0
                    binding.txtCounterNumber.text = count.toString()
                    dialog.dismiss()
                }
                .setNegativeButton("خیر", null)
                .create()
        }
        val customFont = ResourcesCompat.getFont(requireContext(), R.font.iran_sans_regular)
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
                }
            }
            show()
        }
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    companion object {
        fun newInstance(dayOfTheWeek: String, prayOfTheDay: String): FragmentZekrCounter {
            return FragmentZekrCounter().apply {
                arguments =
                    Bundle().apply {
                        putString("DAY_OF_THE_WEEK", dayOfTheWeek)
                        putString("PRAY_OF_THE_WEEK", prayOfTheDay)
                    }
            }
        }
    }

}