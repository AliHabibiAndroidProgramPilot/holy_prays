package com.ali.holyprays.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.ali.holyprays.databinding.FragmentMemorialBinding


class MemorialFragment : Fragment() {

    private lateinit var binding: FragmentMemorialBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMemorialBinding.inflate(inflater)
        val backPressedDispatchers = requireActivity().onBackPressedDispatcher
        backPressedDispatchers.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    parentFragmentManager.popBackStack()
                }
            }
        )
        binding.icNavigationBack.setOnClickListener {
            backPressedDispatchers.onBackPressed()
        }
        return binding.root
    }

}