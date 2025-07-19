package com.ali.holyprays.mvp.ext

interface FragmentZekrCounterContract {

    interface View {
        fun initializeViewTexts()
        fun count()
        fun reset()
        fun vibration()
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onDetach()
    }

}