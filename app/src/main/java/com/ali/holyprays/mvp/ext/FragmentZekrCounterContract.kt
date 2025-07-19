package com.ali.holyprays.mvp.ext

interface FragmentZekrCounterContract {

    interface View {
        fun initializeViewTexts()
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onDetach()
    }

}