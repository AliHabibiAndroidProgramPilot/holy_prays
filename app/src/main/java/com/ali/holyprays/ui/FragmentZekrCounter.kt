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

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

}