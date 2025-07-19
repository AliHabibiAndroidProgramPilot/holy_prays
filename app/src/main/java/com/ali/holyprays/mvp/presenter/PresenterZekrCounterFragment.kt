package com.ali.holyprays.mvp.presenter

import com.ali.holyprays.mvp.ext.FragmentZekrCounterContract

class PresenterZekrCounterFragment : FragmentZekrCounterContract.Presenter {

    private var view: FragmentZekrCounterContract.View? = null

    override fun onAttach(view: FragmentZekrCounterContract.View) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

}