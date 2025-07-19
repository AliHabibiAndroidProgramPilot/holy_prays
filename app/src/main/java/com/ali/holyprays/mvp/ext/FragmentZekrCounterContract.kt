package com.ali.holyprays.mvp.ext

interface FragmentZekrCounterContract {

    interface View {
        fun initializeViewTexts()
        fun count()
        fun reset()
        fun vibration()
        fun showAlertDialog()
        fun navigationBackHandler()
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onDetach()
    }

}