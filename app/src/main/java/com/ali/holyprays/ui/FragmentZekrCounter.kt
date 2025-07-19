package com.ali.holyprays.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ali.holyprays.databinding.FragmentZekrCounterBinding
import com.ali.holyprays.mvp.ext.FragmentZekrCounterContract
import com.ali.holyprays.mvp.presenter.PresenterZekrCounterFragment

class FragmentZekrCounter : Fragment(), FragmentZekrCounterContract.View {

    private lateinit var binding: FragmentZekrCounterBinding

    private lateinit var presenter: FragmentZekrCounterContract.Presenter

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
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initializeViewTexts() {
        binding.txtDayOfWeek.text = arguments?.getString("DAY_OF_THE_WEEK")
        binding.txtDayPray.text = arguments?.getString("PRAY_OF_THE_WEEK")
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