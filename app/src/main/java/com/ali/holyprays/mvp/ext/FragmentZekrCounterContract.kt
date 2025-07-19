package com.ali.holyprays.mvp.ext

interface FragmentZekrCounterContract {

    interface View {

    }

    interface Presenter {

        fun onAttach(view: View)

        fun onDetach()

    }

}